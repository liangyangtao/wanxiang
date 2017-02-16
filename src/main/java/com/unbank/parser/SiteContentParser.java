package com.unbank.parser;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.unbank.mybatis.entity.Parser;
import com.unbank.util.JsoupElementTools;

@Component
public class SiteContentParser extends BaseParser {

	public String getContentCssPath(Document document, String contentText) {
		String csspath = null;
		// 如果校验文本为空，就找相同host 的csspath
		if (contentText == null || contentText.isEmpty()) {
			csspath = getContentCssPathByHost(document);
		} else { // 如果不为空，根据提示的文字找出对应的区域
			csspath = getContentCssPathByText(document, contentText);
		}
		return csspath;
	}

	public String getContentCssPathByText(Document document, String contentText) {
		Elements wantElements = document.body().select(":containsOwn(" + contentText.trim() + ")");
		String contentCssPath = null;
		for (Element element : wantElements) {
			StringBuffer cssPath = new StringBuffer();
			contentCssPath = JsoupElementTools.checkPathNoIndex(document, element, cssPath).toString();
		}
		return contentCssPath;
	}

	public String getContentCssPathByHost(Document document) {
		String contentCssPath = null;
		String url = document.baseUri();
		Parser parser = getParserByHost(url);
		if (parser == null) {
			Element element = getContentNode(document);
			StringBuffer cssPath = new StringBuffer();
			contentCssPath = JsoupElementTools.checkPathNoIndex(document, element, cssPath).toString();
		} else {
			contentCssPath = getCssPathByParser(parser, "contentCssPath");
		}
		return contentCssPath;
	}

	public Element getContentNode(Document document) {
		// 去掉不需要的HTML标签
		removeNoNeedElementsByCssQuery(document.body());
		// 获取内容字数最多的节点
		Element contentbody = getContentBody(document);
		return contentbody;
	}

	public void formatImage(Element contentbody) {
		if (contentbody == null) {
			return;
		}
		Elements elements = contentbody.select("img");
		for (Element element : elements) {
			if ("display:none;".equals(element.attr("style"))) {
				element.remove();
				continue;
			}
			String imgSrc = element.absUrl("src");
			element.attr("src", imgSrc);
			Attributes attributes = element.attributes();
			for (Attribute attribute : attributes) {
				if (attribute.getKey().isEmpty()) {
					continue;
				} else if (attribute.getKey().equals("src")) {
					continue;
				} else {
					element.removeAttr(attribute.getKey());
				}
			}
		}

	}

	// 去掉不需要的HTML标签
	public void removeNoNeedElementsByCssQuery(Element contentElement) {
		String cssQuerys[] = new String[] { "script", "style", "textarea", "select", "noscript", "input", "ins",
				"li > a" };
		for (String string : cssQuerys) {
			removeNoNeedElement(contentElement, string);
		}
	}

	public void removeNoNeedElement(Element element, String cssQuery) {
		if (element == null) {
			return;
		}
		Elements elements = element.select(cssQuery);
		for (Element element2 : elements) {
			element2.remove();
		}
	}

	public Element getContentBody(Element body) {
		Element contentElement = getMaxLengthChild(body);
		Element bodyElement = body.clone();
		removeAdvertiseLink(bodyElement);
		Element parentElement = contentElement.parent();
		while (true) {
			String parentElementText = parentElement.text().replaceAll("\\s{0,10}", "").replace(" ", "");
			String bodyElementText = bodyElement.text().replaceAll("\\s{0,10}", "").replace(" ", "");
			float size = (float) parentElementText.length() / bodyElementText.length();
			if (size < 0.26) {
				parentElement = parentElement.parent();
			} else {
				break;
			}
		}
		return parentElement;
	}

	// 获取内容文字 最多的节点
	public Element getMaxLengthChild(Element parentElement) {
		Element temp = parentElement;
		if (temp == null) {
			return null;
		}
		while (true) {
			Elements childElements = temp.children();
			for (int i = 0; i < childElements.size() - 1; i++) {
				for (int j = i + 1; j < childElements.size(); j++) {
					// 如果包含标题
					int iLength = getElemnetTextLength(childElements.get(i).text());
					int jLength = getElemnetTextLength(childElements.get(j).text());
					if (iLength < jLength) {
						Element tempElemnt = childElements.get(i);
						childElements.set(i, childElements.get(j));
						childElements.set(j, tempElemnt);
					}
				}
			}
			// 找到结果最大的那个
			temp = childElements.first();
			if (temp != null && temp.text().trim().length() <= 50) {
				temp = getIncludeTextNode(temp);
				break;
			}
			if (temp.children().size() == 0) {
				if (temp.text().trim().length() <= 50) {
					temp = getIncludeTextNode(temp);
				}
				break;
			}
		}
		return temp;
	}

	// 获取包含文字的父节点
	public Element getIncludeTextNode(Element temp) {
		while (true) {
			temp = temp.parent();
			if (temp == null) {
				break;
			}
			if (temp.text().trim().length() >= 50) {
				break;
			}

		}
		return temp;
	}

	// 获取文本的长度
	public int getElemnetTextLength(String itext) {
		int iLength = 0;
		char[] iarray = itext.toCharArray();
		for (char c : iarray) {
			if (c == ',' || c == '，') {
				iLength = iLength + 10;
			} else if (c == '。') {
				iLength = iLength + 30;
			} else {
				iLength = iLength + 1;
			}
		}
		return iLength;
	}

	public void removeAdvertiseLink(Element maxTextElement) {
		if (maxTextElement == null) {
			return;
		}
		Elements elements = maxTextElement.select("a");
		for (Element element : elements) {
			if (element.text().length() > 10) {
				element.remove();
			}
		}
	}

}
