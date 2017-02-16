package com.unbank.parser;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.unbank.mybatis.entity.Parser;
import com.unbank.util.JsoupElementTools;

@Component
public class SiteListParser extends BaseParser {

	public String getListCssPath(Document document, String listText) {
		String csspath = null;
		// 如果校验文本为空，就找相同host 的csspath
		if (listText == null || listText.isEmpty()) {
			csspath = getListCssPathByHost(document);
		} else { // 如果不为空，根据提示的文字找出对应的区域
			csspath = getListCssPathByText(document, listText);
		}
		return csspath;
	}

	/***
	 * 通过host 获取csspath
	 * 
	 * @param document
	 * @return
	 */
	public String getListCssPathByHost(Document document) {
		String linkCssPath = null;
		String url = document.baseUri();
		Parser parser = getParserByHost(url);
		if (parser == null) {
			Element element = getPossibleListElement(document);
			StringBuffer cssPath = new StringBuffer();
			cssPath = JsoupElementTools.checkPathNoIndex(document, element, cssPath);
			cssPath = cssPath.append("  a");
			linkCssPath = cssPath.toString();
		} else {
			linkCssPath = getCssPathByParser(parser, "listCssPath");
		}
		return linkCssPath;
	}

	/***
	 * 通过包含的文本获取csspath
	 * 
	 * @param document
	 * @param contentText
	 * @return
	 */
	public String getListCssPathByText(Document document, String contentText) {
		Elements wantElements = document.select(":containsOwn(" + contentText + ")");
		String linkCssPath = null;
		for (Element element : wantElements) {
			StringBuffer cssPath = new StringBuffer();
			linkCssPath = JsoupElementTools.checkPathNoIndex(document, element, cssPath).toString();
			if (linkCssPath.contains("a")) {
				if (linkCssPath.contains("body")) {
				} else {
					Elements elements = document.select(linkCssPath);
					if (elements.size() <= 3) {
						// 表明csspth 范围过小
						String topCss = linkCssPath.split(">")[0];
						elements = document.select(topCss);
						for (Element element2 : elements) {
							element = element2.parent();
							break;
						}
						cssPath.insert(0, ">");
						linkCssPath = JsoupElementTools.checkPathNoIndex(document, element, cssPath).toString();
						if (topCss.contains(".") || topCss.contains("#")) {
							if (topCss.contains(".")) {
								linkCssPath = linkCssPath.replace(topCss, topCss.split(".")[0]);
							} else if (topCss.contains("#")) {
								linkCssPath = linkCssPath.replace(topCss, topCss.split("#")[0]);
							}
						}
						continue;
					}
				}
				break;
			}
		}
		return linkCssPath;

	}

	/***
	 * 比较文本长度来获得， 只是比较的第一层，
	 */
	public Element getPossibleListElement(Document document) {
		// 获取特征节点
		Elements futureNodes = getFutureElements(document);
		Element possibleListElement = getPossibleListElements(document, futureNodes);
		return possibleListElement;

	}

	private Element getPossibleListElements(Element bodyElement, Elements futureNodes) {
		// 如果没有找到特征节点，就找文本最长的节点
		Element wantElement = null;
		if (futureNodes == null || futureNodes.size() == 0) {
			// /
			wantElement = getMaxNumLinkChild(bodyElement);
		} else {
			// 如果找到特征节点 ，就找特征节点的父节点
			Element endElement = futureNodes.get(futureNodes.size() - 1);
			wantElement = getWantlinkNode(endElement);
		}
		return wantElement;
	}

	/**
	 * 返回包含30字以上的节点
	 * 
	 * @param temp
	 * @return
	 */
	public static Element getWantlinkNode(Element temp) {
		while (true) {
			temp = temp.parent();
			if (temp == null) {
				break;
			}
			if (temp.select("a").size() >= 30) {
				break;
			}
		}
		return temp;
	}

	public static Element getMaxNumLinkChild(Element element) {

		if (element == null) {
			return null;
		}
		Element temp = element;
		while (true) {
			Elements childElements = temp.children();
			for (int i = 0; i < childElements.size() - 1; i++) {
				for (int j = i + 1; j < childElements.size(); j++) {
					// 如果包含标题
					int iLength = childElements.get(i).select("a").size();

					int jLength = childElements.get(j).select("a").size();

					if (iLength < jLength) {
						Element tempElemnt = childElements.get(i);
						childElements.set(i, childElements.get(j));
						childElements.set(j, tempElemnt);
					}
				}
			}
			// 找到结果最大的那个

			temp = childElements.first();
			// 如果文本长度已经小于50 则结束
			if (temp != null && temp.text().trim().length() <= 50) {
				temp = JsoupElementTools.getIncludeTextNode(temp);
				break;
			}

			if (temp.children().size() == 0) {
				if (temp.text().trim().length() <= 50) {
					temp = JsoupElementTools.getIncludeTextNode(temp);
				}
				break;
			}
		}
		return temp;
	}

	/***
	 * 获取特征节点
	 * 
	 * @param bodyElement
	 * @return
	 */
	private Elements getFutureElements(Element bodyElement) {
		Elements possibleNode = new Elements();
		Elements elements = bodyElement.select("a");
		for (Element element : elements) {
			String linkText = element.text().trim();
			linkText = linkText.replace(" ", "");
			linkText = linkText.replace("[", "");
			linkText = linkText.replace("]", "");
			// 如果包含特殊字符
			boolean isFuture = checkLinkText(linkText);
			if (isFuture) {
				possibleNode.add(element.parent());
			}
		}
		return possibleNode;
	}

	/***
	 * 判断是否为特征节点
	 * 
	 * @param linkText
	 * @return
	 */
	private boolean checkLinkText(String linkText) {
		String[] feature = { "下一页", "Next", "末页", "尾页" };
		for (int i = 0; i < feature.length; i++) {
			if (feature[i].equals(linkText)) {
				return true;
			} else if (StringUtils.isNumeric(linkText)) {
				return true;
			}
		}
		return false;
	}

}
