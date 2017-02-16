package com.unbank.mybatis.entity;

import java.util.Date;

public class PersistentLogin {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column persistent_logins.series
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	private String series;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column persistent_logins.username
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column persistent_logins.token
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	private String token;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column persistent_logins.last_used
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	private Date lastUsed;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column persistent_logins.series
	 * @return  the value of persistent_logins.series
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column persistent_logins.series
	 * @param series  the value for persistent_logins.series
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column persistent_logins.username
	 * @return  the value of persistent_logins.username
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column persistent_logins.username
	 * @param username  the value for persistent_logins.username
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column persistent_logins.token
	 * @return  the value of persistent_logins.token
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public String getToken() {
		return token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column persistent_logins.token
	 * @param token  the value for persistent_logins.token
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column persistent_logins.last_used
	 * @return  the value of persistent_logins.last_used
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public Date getLastUsed() {
		return lastUsed;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column persistent_logins.last_used
	 * @param lastUsed  the value for persistent_logins.last_used
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
}