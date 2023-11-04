# 目标

- 完成动态协议解析

# 包介绍

| 包名             | 作用                                             |
|----------------|------------------------------------------------|
| cbim           | 主程序<br/> - spring boot 编写                      |
| flow           | 责任链模块<br/> - 各种工厂方法<br/> - 各种模块类<br/> - 初始化责任链 |
| flow-base      | 责任链基础包<br/> - 责任链方法<br/> - 责任链类对象              |
| source-base    | 基础包<br/> - 用于存储各种公有变量                          |
| source-tool    | 工具包<br/> - 本次主要实现从 IOC 中拿 bean 对象              |
| souce-netty    | 使用 netty 做的采集包                                 |
| source-analyse | 动态协议中的解析模块                                     |

# 介绍

简单的构建 `Restful` 请求。

在程序开始时，访问 `http://127.0.0.1:8080/user/info`

返回

```
{"code":200,"message":"成功","data":[{"id":1,"name":"小明"}]}
```

使用网络调试助手发送数据后，再访问该页面，出现

```
{"code":200,"message":"成功","data":[{"id":1,"name":"小红"}]}
```