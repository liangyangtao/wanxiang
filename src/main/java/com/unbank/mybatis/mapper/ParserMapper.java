package com.unbank.mybatis.mapper;

import com.unbank.mybatis.entity.Parser;
import com.unbank.mybatis.entity.ParserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int countByExample(ParserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int deleteByExample(ParserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int insert(Parser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int insertSelective(Parser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	List<Parser> selectByExampleWithBLOBs(ParserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	List<Parser> selectByExample(ParserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	Parser selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByExampleSelective(@Param("record") Parser record, @Param("example") ParserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") Parser record, @Param("example") ParserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByExample(@Param("record") Parser record, @Param("example") ParserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByPrimaryKeySelective(Parser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Parser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parser
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByPrimaryKey(Parser record);
}