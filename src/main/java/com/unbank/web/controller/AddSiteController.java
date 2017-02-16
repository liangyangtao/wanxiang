package com.unbank.web.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.unbank.fetch.Fetcher;
import com.unbank.mybatis.entity.Parser;
import com.unbank.mybatis.entity.Site;
import com.unbank.mybatis.entity.User;
import com.unbank.mybatis.entity.UserSite;
import com.unbank.parser.SiteContentParser;
import com.unbank.parser.SiteListParser;
import com.unbank.parser.SiteTimeParser;
import com.unbank.parser.SiteTitleParser;
import com.unbank.web.model.ParserRule;
import com.unbank.web.model.SearchModel;
import com.unbank.web.service.ParserService;
import com.unbank.web.service.SiteService;
import com.unbank.web.service.UserService;
import com.unbank.web.service.UserSiteService;

@Controller
@RequestMapping("/")
public class AddSiteController extends CommonController {

	static final Logger logger = LoggerFactory.getLogger(AddSiteController.class);

	@Autowired
	SiteService siteService;

	@Autowired
	ParserService parserService;

	@Autowired
	SiteListParser siteListParser;

	@Autowired
	SiteTitleParser siteTitleParser;

	@Autowired
	SiteContentParser siteContentParser;

	@Autowired
	SiteTimeParser siteTimeParser;

	@Autowired
	UserService userService;

	@Autowired
	UserSiteService userSiteService;

	@RequestMapping(value = { "/urlexit" }, method = RequestMethod.POST)
	public void is_url_exit(@RequestParam("url") String url, HttpServletResponse response) {

		Site website = siteService.findByUrl(url);
		String message = null;
		if (website == null) {
			message = "false";
		} else {
			message = "true";
		}
		try {
			responseJson(response, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/addsitelist" }, method = RequestMethod.POST)
	public void feathUrlList(SearchModel searchModel, HttpServletResponse response, ModelMap model) {
		String url = searchModel.getUrl().trim();
		String checkListText = searchModel.getListText();
		String html = Fetcher.getInstance().get(url);
		Document document = Jsoup.parse(html, url);
		String listCssPath = siteListParser.getListCssPath(document, checkListText);
		Elements listElements = document.select(listCssPath);
		List<String> urls = fillUrls(listElements);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("urls", urls);
		result.put("listCssPath", listCssPath);
		try {
			responseJson(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/addsiteInfo" }, method = RequestMethod.POST)
	public void feathSiteInfo(SearchModel searchModel, HttpServletResponse response, ModelMap model) {
		String url = searchModel.getUrl().trim();
		String titleText = searchModel.getTitleText();
		String contentText = searchModel.getContentText();
		String html = Fetcher.getInstance().get(url);
		Document document = Jsoup.parse(html, url);
		String titleCssPath = siteTitleParser.getTitleCssPath(document, titleText);
		String contentCssPath = siteContentParser.getContentCssPath(document, contentText);
		Date date = siteTimeParser.getDate(document);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("time", date);
		Elements titleElements = document.select(titleCssPath);
		String title = null;
		if (titleElements.size() != 0) {
			title = titleElements.first().text();
		}

		result.put("title", title);
		result.put("titleCssPath", titleCssPath);
		Elements contentElements = document.select(contentCssPath);
		String content = null;
		if (contentElements.size() != 0) {
			content = contentElements.first().toString();
		}

		result.put("content", content);
		result.put("contentCssPath", contentCssPath);

		try {
			responseJson(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/addsite" }, method = RequestMethod.POST)
	public String saveSite(ParserRule parseRule, HttpServletResponse response, ModelMap model) {
		String url = parseRule.getUrl().trim();
		String siteName = parseRule.getSiteName().trim();
		String sectionName = parseRule.getSectionName().trim();
		String ssoId = getPrincipal();
		User user = userService.findBySSO(ssoId);
		if (user == null) {
			return "redirect:/login";
		}
		int userId = user.getUserId();
		Site site = new Site();
		site.setSiteName(siteName);
		site.setSectionName(sectionName);
		site.setcDate(new Date());
		site.setOrderNum(0);
		site.setPrice(0.0);
		site.setLastUpdate(new Date());
		site.setRetryTime(3000);
		site.setSleepTime(3000);
		site.setViewNum(0);
		site.setUrl(url);
		site.setcId(userId);
		site.setTimeOut(3000);
		siteService.saveSite(site);
		int siteid = site.getId();
		Parser parser = new Parser();
		parser.setHost(gethost(url));
		parser.setSiteId(siteid);
		parser.setParseRule(new Gson().toJson(parseRule));
		parserService.saveParser(parser);

		UserSite userSite = new UserSite();
		userSite.setDel(0);
		userSite.setSiteId(siteid);
		userSite.setUserId(userId);
		userSiteService.saveUserSite(userSite);
		model.addAttribute("loggedinuser", ssoId);
		return "redirect:/addwebsite";

	}

	@RequestMapping(value = { "/orderSite" }, method = RequestMethod.POST)
	public String orderSite(SearchModel searchModel, HttpServletResponse response, ModelMap model) {
		String ssoId = getPrincipal();
		User user = userService.findBySSO(ssoId);
		if (user == null) {
			return "redirect:/login"; 
		}
		Integer siteid = searchModel.getSiteid();
		int userId = user.getUserId();
		UserSite userSite = new UserSite();
		userSite.setDel(0);
		userSite.setSiteId(siteid);
		userSite.setUserId(userId);
		userSiteService.saveUserSite(userSite);
 		model.addAttribute("loggedinuser", ssoId);
		return "redirect:/website";

	}

	private List<String> fillUrls(Elements urlElements) {
		List<String> urls = new ArrayList<String>();
		for (Element element : urlElements) {
			if (element.text().trim().length() < 5) {
				element.remove();
				continue;
			}

			removeElementAttr(element);
			if (element.attr("href").trim().isEmpty()) {
				element.remove();
				continue;
			}
			String newAttr = element.absUrl("href").trim();
			if (newAttr == null || newAttr.isEmpty()) {
				element.remove();
				continue;
			}
			element.attr("href", newAttr);
			element.attr("target", "_blank");
			urls.add(element.toString());
		}
		return urls;
	}

	public void removeElementAttr(Element element) {
		if (element == null) {
			return;
		}
		Attributes attributes = element.attributes();
		Iterator<Attribute> iterator = attributes.iterator();
		while (iterator.hasNext()) {
			Attribute attribute = iterator.next();
			if (attribute.getKey().equals("href")) {
				continue;
			} else {
				element.removeAttr(attribute.getKey());
				iterator = attributes.iterator();
			}
		}
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
