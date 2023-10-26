# 目标

- 完成日志系统

# 包介绍

|包名| 作用                                             |
|---|------------------------------------------------|
|cbim| 主程序<br/> - spring boot 编写                      |
|flow| 责任链模块<br/> - 各种工厂方法<br/> - 各种模块类<br/> - 初始化责任链 |
|flow-base| 责任链基础包<br/> - 责任链方法<br/> - 责任链类对象              |
|source-base| 基础包<br/> - 用于存储各种公有变量                          |
|source-tool| 工具包<br/> - 本次主要实现从 IOC 中拿 bean 对象              |
|souce-netty|使用 netty 做的采集包|

## 修复

修复 example2 遗留的 BUG，让 netty 可以断开重连。

## 介绍

系统日志采用 `SLF4J + logback` 的方式构建，因为两者都是 `spring boot` 默认的日志体系，所以，不需要重新引入包。

在最外层的 `application.yml` 中告知日志配置文件的路径

```
logging:
  config: classpath:logback-spring.xml
```

该文件规定了日志怎么输出、以什么样式输出。