package com.liu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liu.domain.User;
import com.liu.service.CallbackListener;
import com.liu.service.CallbackService;
import com.liu.service.UserService;

/**
 * @author liugangxin:
 * @version 创建时间：2017年9月18日 上午11:00:59
 */
public class Consumer {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
		context.start();
		doThing(context);
		/*doThing2(context);
		doThing2(context);
		doThing2(context);
		doThing2(context);*/
	}

	private static void doThing2(ClassPathXmlApplicationContext context) {
		CallbackService callbackService = (CallbackService) context.getBean("callbackService");
		callbackService.addListener("http://127.0.0.1/dubbo/foo.bar", new CallbackListener() {
			public void changed(String msg) {
				System.out.println("callback1:" + msg);
			}
		});
	}

	private static void doThing(ClassPathXmlApplicationContext context) {
		UserService userService = (UserService) context.getBean("userService"); // 获取远程服务代理
		User findUser = userService.findUser("uuu"); // 执行远程方法
		System.out.println(findUser == null ? "" : findUser.userId); // 显示调用结果
	}
}
