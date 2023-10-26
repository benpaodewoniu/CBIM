package com.cbim.sourcenetty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cbim.sourcebase.sourceGlobal.SourceGlobal.dataQueue;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 解码失败，消息格式不对
        if (cause instanceof CorruptedFrameException) {
            logger.error("数据格式异常");
            return;
        }
        // 超过最大长度
        if (cause instanceof TooLongFrameException) {
            logger.error("数据超过最大长度");
            ctx.close();
            return;
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        // 读取 ByteBuf 中的字节数据
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);

        // 将字节数组转换为十六进制字符串
        String hexString = bytesToHexString(bytes);

        // 打印十六进制字符串
        logger.info("接收数据为: " + hexString);

        /*
         * 存取数据
         * */
        dataQueue.offer(bytes);


    }

    // 辅助方法：将字节数组转换为十六进制字符串
    private String bytesToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            // 使用两个字符的十六进制表示，并用空格分隔
            hexString.append(String.format("%02X ", b));
        }
        return hexString.toString().trim();
    }

}

class ClientConnect extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ClientConnect.class);

    private NettyClient nettyClient;

    public ClientConnect(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("连接建立");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.error("连接断开");
        nettyClient.connect();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.READER_IDLE) {
                logger.warn("规定时间内没有数据输入");
            }
        }
    }
}
