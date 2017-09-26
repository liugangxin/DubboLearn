package com.liu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.domain.User;
import com.liu.service.UserService;

/**
 * @author liugangxin:
 * @version 创建时间：2017年9月18日 上午10:28:30
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/doLogin")
	public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response) {
		User findUser = userService.findUser("");
		return findUser == null ? "" : findUser.userName;
	}

}
