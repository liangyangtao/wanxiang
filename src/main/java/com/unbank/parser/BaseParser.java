package com.unbank.parser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.unbank.mybatis.entity.Parser;
import com.unbank.web.service.ParserService;

@Component
public class BaseParser {

	@Autowired
	ParserService parserService;

	public static Map<String, Parser> hostParsers = new LinkedHashMap<String, Parser>();

	public static Map<Integer, Parser> siteParsers = new LinkedHashMap<Integer, Parser>();

	public Parser getParserByHost(String url) {
		Parser parser = hostParsers.get(gethost(url));
		if (parser == null) {
			List<Parser> parsers = parserService.getParserByHost(gethost(url));
			if (parsers.size() == 0) {
				return null;
			} else {
				for (Parser temParser : parsers) {
					siteParsers.put(temParser.getSiteId(), temParser);
				}
				hostParsers.put(parsers.get(0).getHost(), parsers.get(0));
				return parsers.get(0);
			}
		} else {
			return parser;
		}

	}

	public String getCssPathByParser(Parser parser, String csspath) {
		String parserRule = parser.getParseRule();
		Gson gson = new Gson();
		Map<String, String> maps = gson.fromJson(parserRule, Map.class);
		return maps.get(csspath);

	}

	/***
	 * 通过url 获取host
	 * 
	 * @param url
	 * @return
	 */
	public String gethost(String url) {
		String domain = "";
		try {
			URL u = new URL(url);
			domain = u.getHost();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return domain;
	}
}
