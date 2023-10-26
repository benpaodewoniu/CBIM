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

需要注意的是，我将之前 `cbim` 中的 `config` 文件夹提到了最外面。

这是因为，对于 `IDEA` 来说，工作路径在 `example*` 的父路径。所以，`spring boot` 自动加载的是工作路径的配置。

虽然可以通过 [@PropertySource](https://benpaodewoniu.github.io/2021/07/21/spring6/) 来解决，但是感觉有点麻烦，所以干脆提到了外面。

## netty 工作流程详解

本章节使用 `netty` 写了一个服务端。

其内部处理器细节如下

```
// 设置数据处理时间上的限定，比如，下面是 30s 如果 netty 没有取到数据的话，就会触发 ClientConnect 的 userEventTriggered 方法
ch.pipeline().addLast(new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS));
// ClientConnect 主要用于处理连接、断开、异常等
ch.pipeline().addLast(new ClientConnect(netty));
// 编码器，详情请参考 README.md
ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(100, 1, 2, 1, 3, true));
// 存储数据，处理异常
ch.pipeline().addLast(new ClientHandler());
```

这里重点讲一下编码器 `LengthFieldBasedFrameDecoder`。

首先，咱们使用网络助手或者其他发包工具，向 `netty` 绑定端口，比如 `5566` 发送数据。

假设，咱们的真实数据就 `12` 字节。如果一次性发送超过 100 个字节或者发送 `5` 个字节，那 netty 会怎么处理呢？

`netty` 会先拼包，然后根据 `LengthFieldBasedFrameDecoder` 的规则进行切包处理，只有符合规定的数据才会进入 `ClientHandler`，否则会根据实际情况报各种错。

关于 `LengthFieldBasedFrameDecoder` 请参考该博文 [java | LTC 解码器](https://benpaodewoniu.github.io/2023/01/27/java214/)

举几个简单的例子。

真正的数据是 `CA 00 0C FE 01 02 03 04 04 06 07 08 09 12 11 22`

### 半包发送

使用网络助手先发

- `CA 00 0C FE 01 02`

再发

- `03 04 04 06 07 08 09 12 11 22`

该程序输出

```
接收数据为: FE 01 02 03 04 04 06 07 08 09 12 11 22
```

说明 `netty` 做了拼包处理。

### 粘包处理

直接发送 

- `CA 00 0C FE 01 02 03 04 04 06 07 08 09 12 11 22 CA 00 0C FE 02 02 02 02 02 02 02 02 02 02 02 02`

程序输出

```
接收数据为: FE 01 02 03 04 04 06 07 08 09 12 11 22
接收数据为: FE 02 02 02 02 02 02 02 02 02 02 02 02
```

说明 `netty` 已经对粘包做了切包处理。

### 不符合规定处理

不断地发送

- `CA 00 0C FE 01 02 03 04 04 06 07 08 09 12 11 22 AA`

该程序输出

```
接收数据为: FE 01 02 03 04 04 06 07 08 09 12 11 22
数据超过最大长度
连接断开
Thread[nioEventLoopGroup-2-1,10,main]
Thread[nioEventLoopGroup-2-2,10,main]
连接成功
连接建立
```

怎么理解上述输出呢？

首先，你发送 `CA 00 0C FE 01 02 03 04 04 06 07 08 09 12 11 22 AA` ，`netty` 解析出正确数据 `CA 00 0C FE 01 02 03 04 04 06 07 08 09 12 11 22`，此时，该数据段还剩一个 `AA`。

所以，`AA` 还留存在 `netty` 的消息队列中，后续继续进消息，由于 `AA` 的存在导致，数据解析一直失败，然后积压的数据超过 `LengthFieldBasedFrameDecoder` 设置的上限，然后报错。

该报错被 `ClientHandler` 异常处理中的 `TooLongFrameException` 捕获，并断开连接。ps: 我觉得直接断开连接不够优雅，但是，目前没找到其他办法。

## 遗留的问题

这一章节中，只有 `5566` 端口服务器已经开了，客户端才能连接，否则会报错。这个将在下一个案例中修改。