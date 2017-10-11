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
//		testCallback(context);
		/*while(true){
			Thread.sleep(1000);
		}*/
	}

	// 参数回调,其中key为任意，查看provider的回调实现类
	//如果想简单些，则服务端不用实现，直接在方法执行时，调用自定义CallbackListener接口对象方法即可
	private static void testCallback(ClassPathXmlApplicationContext context) {
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
