package com.cbim.cbim.service.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnOpen;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.Session;


@ServerEndpoint(value = "/websocket")
@Component
public class CBIMWebsocket {

    private static final Logger logger = LoggerFactory.getLogger(CBIMWebsocket.class);

    @OnOpen
    public void onOpen(Session session) {
        logger.info(session.toString());
    }

    @OnClose
    public void onClose(Session session) {

    }
}
