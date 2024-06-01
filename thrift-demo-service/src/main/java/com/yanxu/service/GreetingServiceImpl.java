package com.yanxu.service;

import org.apache.thrift.TException;

import java.util.logging.Logger;

/**
 * 接口实现类
 */
public class GreetingServiceImpl implements GreetingService.Iface {

    private static Logger logger = Logger.getLogger(GreetingServiceImpl.class.getName());

    public String sayHello(String name) throws TException {
        logger.info(String.format("调用sayHello方法的参数name={%s}", name));
        return "Hello" + name;
    }
}
