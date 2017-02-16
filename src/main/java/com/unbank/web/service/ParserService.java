package com.unbank.web.service;

import java.util.List;

import com.unbank.mybatis.entity.Parser;

public interface ParserService {

	public List<Parser> getParserByHost(String host);

	public List<Parser> getParserBySiteId(Integer siteid);

	public void saveParser(Parser parser);

}
