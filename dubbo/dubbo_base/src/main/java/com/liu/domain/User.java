package com.liu.domain;

import java.io.Serializable;

/**
 * @author liugangxin:
 * @version 创建时间：2017年9月18日 上午10:22:18
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8780758333502180858L;
	public final int userId;
	public final String userName;

	public User(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

}
