package com.unbank.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unbank.mybatis.entity.Site;
import com.unbank.mybatis.entity.SiteExample;
import com.unbank.mybatis.entity.UserSite;
import com.unbank.mybatis.entity.UserSiteExample;
import com.unbank.mybatis.mapper.SiteMapper;
import com.unbank.mybatis.mapper.UserSiteMapper;
import com.unbank.web.model.SearchModel;
import com.unbank.web.service.SiteService;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {

	@Inject
	public SiteMapper siteMapper;

	@Inject
	public UserSiteMapper userSiteMapper;

	/***
	 * 获取用户自己录入的数据源,如果用户为空则显示所有的
	 * 
	 */
	public List<Site> getSiteList(Integer pagenum, Integer pagesize, SearchModel searchModel) {
		// 订购的
		if (searchModel.getMyac() == 1) {
			return getSiteListByUserId(searchModel, pagenum, pagesize);
		} else if (searchModel.getMyac() == 2) {
			// 自己发布的
			SiteExample siteExample = new SiteExample();
			fillsearchModel(searchModel, siteExample);
			siteExample.setOrderByClause("id desc  limit " + (pagenum - 1) * pagesize + "," + pagesize);
			return siteMapper.selectByExample(siteExample);
		} else {
			searchModel.setcId(0);
			SiteExample siteExample = new SiteExample();
			fillsearchModel(searchModel, siteExample);
			return siteMapper.selectByExample(siteExample);
		}
	}

	/***
	 * 获取数据源数量
	 *
	 * @param userid
	 * @return
	 */
	public Integer getSiteSize(SearchModel searchModel) {
		if (searchModel.getMyac() == 1) {
			SiteExample example = new SiteExample();
			fillsearchModel(searchModel, example);
			int userid = searchModel.getcId();
			if (userid != 0) {
				UserSiteExample userSiteExample = new UserSiteExample();
				userSiteExample.or().andUserIdEqualTo(userid).andDelEqualTo(0);
				List<UserSite> userSites = userSiteMapper.selectByExample(userSiteExample);
				List<Integer> values = new ArrayList<Integer>();
				for (UserSite userSite : userSites) {
					values.add(userSite.getSiteId());
				}
				if (values.size() > 0) {
					example.or().andIdIn(values);
				}
			}
			return siteMapper.countByExample(example);
		} else if (searchModel.getMyac() == 2) {
			SiteExample siteExample = new SiteExample();
			fillsearchModel(searchModel, siteExample);
			return siteMapper.countByExample(siteExample);
		} else {
			SiteExample siteExample = new SiteExample();
			searchModel.setcId(0);
			fillsearchModel(searchModel, siteExample);
			return siteMapper.countByExample(siteExample);
		}

	}

	/***
	 * 获取某用户的订阅数据源
	 */
	public List<Site> getSiteListByUserId(SearchModel searchModel, int pagenum, int pagesize) {

		SiteExample example = new SiteExample();
		fillsearchModel(searchModel, example);
		int userid = searchModel.getcId();
		if (userid != 0) {
			UserSiteExample userSiteExample = new UserSiteExample();
			userSiteExample.or().andUserIdEqualTo(userid).andDelEqualTo(0);
			List<UserSite> userSites = userSiteMapper.selectByExample(userSiteExample);
			List<Integer> values = new ArrayList<Integer>();
			for (UserSite userSite : userSites) {
				values.add(userSite.getSiteId());
			}
			if (values.size() > 0) {
				example.or().andIdIn(values);
			}
		}
		example.setOrderByClause("id desc limit " + (pagenum - 1) * pagesize + "," + pagesize);
		return siteMapper.selectByExample(example);
	}

	private void fillsearchModel(SearchModel searchModel, SiteExample siteExample) {
		com.unbank.mybatis.entity.SiteExample.Criteria criteria = siteExample.createCriteria();
		Integer cid = searchModel.getcId();
		if (cid != null && cid != 0) {
			criteria.andCIdEqualTo(cid);
		}
		Date lastUpdate = searchModel.getLastUpdate();
		if (lastUpdate != null) {
			criteria.andLastUpdateEqualTo(lastUpdate);
		}
		Date startTime = searchModel.getStartTime();
		if (startTime != null) {
			criteria.andLastUpdateGreaterThanOrEqualTo(startTime);
		}
		Date endTime = searchModel.getEndTime();
		if (endTime != null) {
			criteria.andLastUpdateLessThan(endTime);
		}
		String sectionName = searchModel.getSectionName();
		if (sectionName != null && !sectionName.isEmpty()) {
			criteria.andSectionNameLike("%" + sectionName + "%");
		}
		String siteName = searchModel.getSiteName();
		if (siteName != null && !siteName.isEmpty()) {
			criteria.andSiteNameLike("%" + siteName + "%");
		}
		String url = searchModel.getUrl();
		if (url != null && !url.isEmpty()) {
			criteria.andUrlLike("%" + url + "%");
		}
	}

	/****
	 * 某个url是否录入
	 */
	public Site findByUrl(String url) {
		if (!url.isEmpty()) {
			SiteExample example = new SiteExample();
			example.or().andUrlEqualTo(url.trim());
			List<Site> sites = siteMapper.selectByExample(example);
			if (sites.size() > 0) {
				return sites.get(0);
			}
		}
		return null;
	}

	public void saveSite(Site site) {

		siteMapper.insertSelective(site);

	}

}
