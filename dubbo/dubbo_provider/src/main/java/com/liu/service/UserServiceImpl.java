package com.liu.service;

import org.springframework.stereotype.Service;

import com.liu.domain.User;

/**
 * @author liugangxin:
 * @version 创建时间：2017年9月18日 上午10:23:18
 */

public class UserServiceImpl implements UserService {

	private static final int id = 1;
	public User findUser(String userName) {
		return new User(id, "liu");
	}

}
