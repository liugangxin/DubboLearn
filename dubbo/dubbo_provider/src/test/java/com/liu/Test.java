package com.liu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author liugangxin:
* @version 创建时间：2017年9月18日 上午10:57:08
*/
public class Test {

	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}
