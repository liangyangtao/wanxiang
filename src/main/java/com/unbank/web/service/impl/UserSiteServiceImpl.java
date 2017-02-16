package com.unbank.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unbank.mybatis.entity.UserSite;
import com.unbank.mybatis.entity.UserSiteExample;
import com.unbank.mybatis.mapper.UserSiteMapper;
import com.unbank.web.service.UserSiteService;

@Repository
public class UserSiteServiceImpl implements UserSiteService {

	@Autowired
	UserSiteMapper userSiteMapper;

	public void saveUserSite(UserSite userSite) {
		userSiteMapper.insertSelective(userSite);
	}

	public List<UserSite> getUserSitesByUserid(int userid) {

		UserSiteExample userSiteExample = new UserSiteExample();
		userSiteExample.or().andUserIdEqualTo(userid).andDelEqualTo(0);
		return userSiteMapper.selectByExample(userSiteExample);

	}

}
