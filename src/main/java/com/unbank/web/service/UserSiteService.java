package com.unbank.web.service;

import java.util.List;

import com.unbank.mybatis.entity.UserSite;

public interface UserSiteService {

	public void saveUserSite(UserSite userSite);

	public List<UserSite> getUserSitesByUserid(int userid);
}
