package com.cbim.cbimwebsocket.component;

import io.netty.handler.codec.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.*;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;


@ServerEndpoint(path = "/websocket", host = "127.0.0.1", port = 9889)
@Component
public class CBIMWebsocket {

    private static final Logger logger = LoggerFactory.getLogger(CBIMWebsocket.class);

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, ParameterMap parameterMap) throws Exception {
        logger.info("wesocket 发送请求已接收");
        session.sendText("服务器已接收该信息");
    }

    @OnClose
    public void onClose(Session session) throws Exception {

        logger.info("websocket 连接关闭");

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.error(throwable.toString());
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        logger.info(message);
    }
}
