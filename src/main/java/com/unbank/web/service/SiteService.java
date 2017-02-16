package com.unbank.web.service;

import java.util.List;

import com.unbank.mybatis.entity.Site;
import com.unbank.web.model.SearchModel;

public interface SiteService {


	public Site findByUrl(String url);

	public Integer getSiteSize(SearchModel site);

	public List<Site> getSiteList( Integer page, Integer rows, SearchModel searchModel);
	
	public void saveSite(Site site);

}
