package com.unbank.mybatis.mapper;

import com.unbank.mybatis.entity.Site;
import com.unbank.mybatis.entity.SiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SiteMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int countByExample(SiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int deleteByExample(SiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int insert(Site record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int insertSelective(Site record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	List<Site> selectByExample(SiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	Site selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByExampleSelective(@Param("record") Site record, @Param("example") SiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByExample(@Param("record") Site record, @Param("example") SiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByPrimaryKeySelective(Site record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	int updateByPrimaryKey(Site record);
}