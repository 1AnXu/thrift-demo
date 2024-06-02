代码结构` version 1.0`

```shell
# 本结构是一个入门小demo，涉及的服务只有一个——>GreetingService
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

代码结构`version2.0` (太多了，直接见代码吧 )

步骤

1. `interface`模块

   - 编写`Thrift`文件（包含了实体类、接口服务等）-->`student.thrift`

   - 使用`Thrift`命令编译`.thrift`文件，生成对应的`Java`文件（可能有多个文件），并粘贴到对应的`package`路径（由`namespace`指定）下（**注意：package路径中不能与Java关键字，不然会变成普通文件夹**）

     > ```shell
     > # Thrift命令
     > thrift -gen java student.thrift
     > ```

2. `service`模块

   - 在`pom.xml`文件中引入`interface`模块的依赖
   - 编写接口实现类实现`StudentService.Iface`接口

3. `server`模块

   - 在`pom.xml`文件中引入`service`模块的依赖

   - 根据`application.yml`的配置（端口、线程数量等信息）编写`Server`类及`start()`方法

   - 编写启动类，**一定要加上以下注解，以扫描和注册`service`模块的`Bean`**

     > ```java
     > @ComponentScan(basePackages = {"com.yanxu.thriftServer", "com.yanxu.thriftService"})
     > ```

4. `client`模块

   - 编写`ThriftClient`类
   - 根据`application.yml`文件，编写`ThriftClientConfig`配置类，将`ThriftClient`交给`IOC`来管理
   - 根据`MVC`架构，编写`Service`层(注入`ThriftClient`对象并调用服务)，`Controller`层





参考博客

- 简单入门小Demo [一步步完成thrift rpc示例](https://mp.weixin.qq.com/s?__biz=MzAxMTY0Nzg1Mg==&mid=2648941714&idx=1&sn=ae4bb5bdac4773c2cbf8c070d4d4e199&chksm=83aaea91b4dd638707bda31e5277d5b702844efa48162eef9df200bd10e052b584148d4bf861&scene=21#wechat_redirect)
- 涵盖了很多Thrift的基础知识，适合进一步了解 [SpringBoot整合RPC框架---Thrift](https://blog.csdn.net/lupengfei1009/article/details/100934794)
- SpringBoot整合Thrift，涵盖了很多Thrift的知识 [Thrift 使用教程](https://cloud.tencent.com/developer/article/1688361)

踩坑：
- [SpringBoot多模块项目引入其他模块时@Autowired无法注入的问题](https://blog.csdn.net/weixin_42326851/article/details/123894504)