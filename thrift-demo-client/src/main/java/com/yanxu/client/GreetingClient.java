package com.yanxu.client;

import com.yanxu.service.GreetingService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.logging.Logger;

public class GreetingClient {

    private static final Logger logger = Logger.getLogger(GreetingClient.class.getName());

    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("127.0.0.1", 9090);//指定服务端地址和端口号

            TProtocol protocol = new TBinaryProtocol(transport);//指定协议：二进制编码格式
            GreetingService.Client client = new GreetingService.Client(protocol);//建立客户端

            transport.open();//建立连接
            String name = "Eric";
            logger.info("请求参数==>name为" + name);
            String result = client.sayHello("Eric");//RPC调用
            logger.info("返回结果==>为" + result);
            transport.close();//关闭连接
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
