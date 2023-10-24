# 目标

- 完成 netty 采集模块的编写

# 包介绍

|包名| 作用                                             |
|---|------------------------------------------------|
|cbim| 主程序<br/> - spring boot 编写                      |
|flow| 责任链模块<br/> - 各种工厂方法<br/> - 各种模块类<br/> - 初始化责任链 |
|flow-base| 责任链基础包<br/> - 责任链方法<br/> - 责任链类对象              |
|source-base| 基础包<br/> - 用于存储各种公有变量                          |
|source-tool| 工具包<br/> - 本次主要实现从 IOC 中拿 bean 对象              |
|souce-netty|使用 netty 做的采集包|

# 需要学习的点

## config 的配置路径

需要注意的是，我将之前 cbim 中的 config 文件夹提到了最外面。

这是因为，对于 IDEA 来说，工作路径在 example* 的父路径。所以，spring boot 自动加载的是工作路径的配置。

虽然可以通过 [@PropertySource](https://benpaodewoniu.github.io/2021/07/21/spring6/) 来解决，但是感觉有点麻烦，所以干脆提到了外面。

