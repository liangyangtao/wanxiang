package com.unbank.web.model;

import java.io.Serializable;
import java.util.Date;

/***
 * 查询model
 * 
 * @ClassName: SearchModel
 * @Description: TODO
 * @author: liangyangtao
 */
public class SearchModel implements Serializable {
	private static final long serialVersionUID = 7902035888382606204L;

	private int siteid;
	
	private String siteName;

	private String sectionName;

	private String url;

	private String status;

	private Integer viewNum;

	private Integer cId;

	private Date cDate;

	private Integer rank;

	private Integer orderNum;

	private Double price;

	private Date lastUpdate;

	private Integer retryTime;

	private Integer sleepTime;

	private Integer timeOut;

	private Date startTime;

	private Date endTime;


	private Integer page;
	private Integer rows;

	private String listText;
	private String titleText;
	private String contentText;
	private String timeText;
	
	private String listCssPath;
	private String titleCssPath;
	private String contentCssPath;
	private String timeCssPath;
	
	private int myac;

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getViewNum() {
		return viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getRetryTime() {
		return retryTime;
	}

	public void setRetryTime(Integer retryTime) {
		this.retryTime = retryTime;
	}

	public Integer getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(Integer sleepTime) {
		this.sleepTime = sleepTime;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getListText() {
		return listText;
	}

	public void setListText(String listText) {
		this.listText = listText;
	}

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getTimeText() {
		return timeText;
	}

	public void setTimeText(String timeText) {
		this.timeText = timeText;
	}

	public String getListCssPath() {
		return listCssPath;
	}

	public void setListCssPath(String listCssPath) {
		this.listCssPath = listCssPath;
	}

	public String getTitleCssPath() {
		return titleCssPath;
	}

	public void setTitleCssPath(String titleCssPath) {
		this.titleCssPath = titleCssPath;
	}

	public String getContentCssPath() {
		return contentCssPath;
	}

	public void setContentCssPath(String contentCssPath) {
		this.contentCssPath = contentCssPath;
	}

	public String getTimeCssPath() {
		return timeCssPath;
	}

	public void setTimeCssPath(String timeCssPath) {
		this.timeCssPath = timeCssPath;
	}

	public int getMyac() {
		return myac;
	}

	public void setMyac(int myac) {
		this.myac = myac;
	}

	public int getSiteid() {
		return siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

}
