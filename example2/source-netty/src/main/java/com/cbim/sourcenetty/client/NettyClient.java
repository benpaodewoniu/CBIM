package com.cbim.sourcenetty.client;

import com.cbim.sourcebase.entity.NettyAddress;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class NettyClient extends Thread {

    Bootstrap bootstrap = new Bootstrap();

    @Autowired
    private NettyAddress nettyAddress;

    @Override
    public void run() {
        start();
        connect();
    }

    ;

    public void start() {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            bootstrap
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS));
                            ch.pipeline().addLast(new ClientConnect());
                            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(100, 0, 0, 0, 0, true));
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public void connect() {
//        bootstrap.connect(nettyAddress.getHost(), nettyAddress.getPort());
        bootstrap.connect("127.0.0.1", 5566);
    }
}
