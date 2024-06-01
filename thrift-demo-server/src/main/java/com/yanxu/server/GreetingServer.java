package com.yanxu.server;

import com.yanxu.service.GreetingService;
import com.yanxu.service.GreetingServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.util.logging.Logger;

/**
 * Hello world!
 */
public class GreetingServer {
    private static final Logger logger = Logger.getLogger(GreetingServer.class.getName());

    public static void main(String[] args) {
        try {

            TServerSocket serverTransport = new TServerSocket(9090); // 传输端口

            TProcessor processor = new GreetingService.Processor(new GreetingServiceImpl());//关联processor与服务

            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();//传输协议

            TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverTransport);//transport
            serverArgs.processor(processor);//processor
            serverArgs.protocolFactory(proFactory);//protocolFactory

            TServer server = new TThreadPoolServer(serverArgs);
            logger.info("Start server on port 9090...");

            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
