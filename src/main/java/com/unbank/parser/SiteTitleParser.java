package com.unbank.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.unbank.mybatis.entity.Parser;
import com.unbank.util.JsoupElementTools;

@Component
public class SiteTitleParser extends BaseParser {

	public String getTitleCssPath(Document document, String titleText) {
		String csspath = getTitleCssPathByHost(document);
		if (csspath == null || csspath.isEmpty()) {
			if (titleText != null && !titleText.isEmpty()) {
				csspath = getTitleCssPathByText(document, titleText);
			}
		}
		if (csspath == null || csspath.isEmpty()) {
			csspath = "title";
		}
		return csspath;
	}

	/***
	 * 根据文本猜测 csspath
	 * 
	 * @param document
	 * @param titleText
	 * @return
	 */
	public String getTitleCssPathByText(Document document, String titleText) {
		Elements wantElements = document.body().select(":containsOwn(" + titleText.trim() + ")");
		String titleCssPath = null;
		for (Element element : wantElements) {
			StringBuffer cssPath = new StringBuffer();
			titleCssPath = JsoupElementTools.checkPathNoIndex(document, element, cssPath).toString();
		}
		return titleCssPath;
	}

	public String getTitleCssPathByHost(Document document) {
		String titleCssPath = null;
		String url = document.baseUri();
		Parser parser = getParserByHost(url);
		if (parser == null) {
		} else {
			titleCssPath = getCssPathByParser(parser, "titleCssPath");
		}
		return titleCssPath;
	}

}
