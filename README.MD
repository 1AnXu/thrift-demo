代码结构

```shell
thrift-demo
│      
│
├─thrift-demo-interface # 1. 定义服务的接口
│  │
│  └─src/main
│          ├─java
│          │  └─com.yanxu.service
│          │           GreetingService.java # 1.3 将生成的java文件放在对应的package下
│          │
│          └─resources
│              └─thrift
│                  │  hello.thrift	# 1.1 编写定义thrift文件
│                  │
│                  └─gen-java	# 1.2 通过thrift编译生成java文件
│                      └─com.yanxu.thrift.service
│                            	GreetingService.java
│
├─thrift-demo-service # 2. 编写服务接口的实现类
│  │
│  └─src/main/java
|              └─com.yanxu.service
|	 					GreetingServiceImpl.java
├─thrift-demo-server # 3.编写服务端，暴露服务
│  │
│  └─src/main/java
│              └─com.yanxu.server
│                      GreetingServer.java						
└─thrift-demo-client # 4.编写客户端，rpc调用服务
   │
   └─src/main/java
               └─com.yanxu.client
                      GreetingClient.java

```

参考博客

- 简单入门小Demo [一步步完成thrift rpc示例](https://mp.weixin.qq.com/s?__biz=MzAxMTY0Nzg1Mg==&mid=2648941714&idx=1&sn=ae4bb5bdac4773c2cbf8c070d4d4e199&chksm=83aaea91b4dd638707bda31e5277d5b702844efa48162eef9df200bd10e052b584148d4bf861&scene=21#wechat_redirect)
- 涵盖了很多Thrift的基础知识，适合进一步了解 [SpringBoot整合RPC框架---Thrift](https://blog.csdn.net/lupengfei1009/article/details/100934794)
- SpringBoot整合Thrift，涵盖了很多Thrift的知识 [Thrift 使用教程](https://cloud.tencent.com/developer/article/1688361)