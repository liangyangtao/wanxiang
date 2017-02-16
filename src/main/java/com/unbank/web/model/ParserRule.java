package com.unbank.web.model;

public class ParserRule {

	String url;
	String siteName;
	String sectionName;
	String listCssPath;
	String titleCssPath;
	String timeCssPath;
	String contentCssPath;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName.trim();
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName.trim();
	}

	public String getListCssPath() {
		return listCssPath;
	}

	public void setListCssPath(String listCssPath) {
		this.listCssPath = listCssPath.trim();
	}

	public String getTitleCssPath() {
		return titleCssPath;
	}

	public void setTitleCssPath(String titleCssPath) {
		this.titleCssPath = titleCssPath.trim();
	}

	public String getTimeCssPath() {
		return timeCssPath;
	}

	public void setTimeCssPath(String timeCssPath) {
		this.timeCssPath = timeCssPath.trim();
	}

	public String getContentCssPath() {
		return contentCssPath;
	}

	public void setContentCssPath(String contentCssPath) {
		this.contentCssPath = contentCssPath.trim();
	}

}
