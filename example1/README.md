# 目标

- 完成责任链的编写

# 包介绍

|包名| 作用                                             |
|---|------------------------------------------------|
|cbim| 主程序<br/> - spring boot 编写                      |
|flow| 责任链模块<br/> - 各种工厂方法<br/> - 各种模块类<br/> - 初始化责任链 |
|flow-base| 责任链基础包<br/> - 责任链方法<br/> - 责任链类对象              |
|source-base| 基础包<br/> - 用于存储各种公有变量                          |
|source-tool| 工具包<br/> - 本次主要实现从 IOC 中拿 bean 对象              |

# 执行逻辑

- `cbim` 中 `Spring boot` 开始执行
- 调用 `flow` 中的 `chain` 方法
- `chain` 方法读取责任链配置，并获取链上各个 `bean` 执行

# 需要学习的点

- `cbim` 的 `Spring boot` 的 `ComponentScan` 的注册其他模块包
- 其他模块包使用 Spring 的注解
- 责任链的 `Yaml` 解析
- 责任链抽象类的执行

# 成功输出

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::      (v2.7.17-SNAPSHOT)

2023-10-23 23:56:22.282  INFO 3716 --- [           main] com.cbim.cbim.CbimApplication            : Starting CbimApplication using Java 17.0.8 on S3 with PID 3716 (D:\JAVA\Code\CBIM\example1\cbim\target\classes started by Administrator in D:\JAVA\Code\CBIM)
2023-10-23 23:56:22.285  INFO 3716 --- [           main] com.cbim.cbim.CbimApplication            : No active profile set, falling back to 1 default profile: "default"
2023-10-23 23:56:23.203  INFO 3716 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-10-23 23:56:23.212  INFO 3716 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-10-23 23:56:23.213  INFO 3716 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.82]
2023-10-23 23:56:23.297  INFO 3716 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-10-23 23:56:23.297  INFO 3716 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 955 ms
2023-10-23 23:56:23.642  INFO 3716 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-23 23:56:23.651  INFO 3716 --- [           main] com.cbim.cbim.CbimApplication            : Started CbimApplication in 1.836 seconds (JVM running for 2.418)
success
```