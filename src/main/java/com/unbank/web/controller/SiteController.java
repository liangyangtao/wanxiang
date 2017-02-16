package com.unbank.web.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.unbank.mybatis.entity.Site;
import com.unbank.mybatis.entity.User;
import com.unbank.mybatis.entity.UserSite;
import com.unbank.util.CommonUtils;
import com.unbank.web.model.SearchModel;
import com.unbank.web.service.SiteService;
import com.unbank.web.service.UserService;
import com.unbank.web.service.UserSiteService;

@Controller
@RequestMapping("/")
public class SiteController extends CommonController {

	static final Logger logger = LoggerFactory.getLogger(SiteController.class);
	@Autowired
	SiteService siteService;

	@Autowired
	UserService userService;

	@Autowired
	UserSiteService userSiteService;

	@RequestMapping(value = { "websitelist" }, method = RequestMethod.POST)
	public void getwebsitelist(HttpServletResponse response, HttpSession session, ModelMap modelMap,
			HttpServletRequest request, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows,
			@ModelAttribute SearchModel searchModel) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 20;
		}
		String ssoId = getPrincipal();
		User user = userService.findBySSO(ssoId);
		int userid = 0;
		if (user != null) {
			userid = user.getUserId();
		}
		searchModel.setcId(userid);

		List<UserSite> usersites = userSiteService.getUserSitesByUserid(userid);
		Set<Integer> siteids = new HashSet<Integer>();
		for (UserSite userSite : usersites) {
			siteids.add(userSite.getSiteId());
		}

		// 总共有多少条
		Integer count = siteService.getSiteSize(searchModel);
		// 总共有多少页
		Integer pageCount = ((count % rows == 0) ? (count / rows) : ((count / rows) + 1));
		List<Site> webistes = siteService.getSiteList(page, rows, searchModel);
		for (Site site : webistes) {
			if (siteids.contains(site.getId())) {
				site.setRank(10);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取分页信息
		CommonUtils.getPageMap(map, page, pageCount);
		map.put("records", count);
		map.put("rowNum", rows);
		map.put("page", page);
		map.put("total", pageCount);
		map.put("rows", webistes);
		try {
			responseJson(response, map);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
