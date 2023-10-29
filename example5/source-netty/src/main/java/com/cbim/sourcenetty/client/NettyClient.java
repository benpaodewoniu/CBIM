package com.cbim.sourcenetty.client;

import com.cbim.sourcebase.entity.NettyAddress;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class NettyClient {

    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    Bootstrap bootstrap = new Bootstrap();
    EventLoopGroup group = new NioEventLoopGroup(4);

    @Autowired
    private NettyAddress nettyAddress;

    ;

    public void start() {

        NettyClient netty = this;

        try {
            bootstrap
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            // 设置数据处理时间上的限定，比如，下面是 30s 如果 netty 没有取到数据的话，就会触发 ClientConnect 的 userEventTriggered 方法
                            ch.pipeline().addLast(new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS));
                            // ClientConnect 主要用于处理连接、断开、异常等
                            ch.pipeline().addLast(new ClientConnect(netty));
                            // 编码器，详情请参考 README.md
                            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(100, 0, 4, 0, 0, true));
                            // 存储数据，处理异常
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void connect() {
        System.out.println(Thread.currentThread());
        bootstrap.connect(nettyAddress.getHost(), nettyAddress.getPort()).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    logger.info("连接成功");
                } else {
                    logger.error("连接失败");

                    // 重新连接

                    future.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            logger.info("重新连接");
                            connect();
                        }
                    }, 5, TimeUnit.SECONDS);
                }
            }

            ;
        });
    }
}
