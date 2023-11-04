# 目标

- websockt 前后端通信

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
| cbim-websocket | websocket 包                                    |

# 功能点

- 跨域增加
- `websocket` 连接增加
- 增加最终处理模块
- 增加比较变化包服务

# 介绍

增加 `index.html` ，可以展示上述功能。