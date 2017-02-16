package com.unbank.web.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unbank.mybatis.entity.Parser;
import com.unbank.mybatis.entity.ParserExample;
import com.unbank.mybatis.mapper.ParserMapper;
import com.unbank.web.service.ParserService;

@Service
@Transactional
public class ParserServiceImpl implements ParserService {

	@Inject
	ParserMapper parserMapper;

	/***
	 * 根据host 获取采集规则
	 */
	public List<Parser> getParserByHost(String host) {
		ParserExample example = new ParserExample();
		example.or().andHostEqualTo(host);
		return parserMapper.selectByExampleWithBLOBs(example);
	}

	/***
	 * 根据id 获取采集规则
	 */
	
	public List<Parser> getParserBySiteId(Integer siteid) {
		ParserExample example = new ParserExample();
		example.or().andSiteIdEqualTo(siteid);
		return parserMapper.selectByExampleWithBLOBs(example);
	}

	// 保存采集规则
	public void saveParser(Parser parser) {
		parserMapper.insertSelective(parser);
	}

}
