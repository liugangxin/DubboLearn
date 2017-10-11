package com.liu.service.test2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

public class MyDubboFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(MyDubboFilter.class);

	public MyDubboFilter() {
	}

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String clientIp = RpcContext.getContext().getRemoteHost();
		logger.info("访问ip为{}", clientIp);
		System.out.println(String.format("访问ip为%s", clientIp));
		return invoker.invoke(invocation);
	}

}
