package com.unbank.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/")
@SessionAttributes("loggedinuser")
public class AdminHomeController extends CommonController {

	static final Logger logger = LoggerFactory.getLogger(AdminHomeController.class);

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("title", "仪表盘");
		model.addAttribute("loggedinuser", getPrincipal());
		return "home";
	}

	@RequestMapping(value = { "/website" }, method = RequestMethod.GET)
	public String website(ModelMap model) {
		model.addAttribute("title", "数据源管理");
		model.addAttribute("loggedinuser", getPrincipal());
		return "website";
	}

	@RequestMapping(value = { "/addwebsite" }, method = RequestMethod.GET)
	public String addwebsite(ModelMap model) {
		model.addAttribute("title", "发布数据源");
		model.addAttribute("loggedinuser", getPrincipal());
		return "addwebsite";
	}

}
