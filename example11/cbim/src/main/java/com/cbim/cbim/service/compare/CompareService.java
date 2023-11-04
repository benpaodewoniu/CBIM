package com.cbim.cbim.service.compare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.yeauty.pojo.Session;

import java.util.Map;

import static com.cbim.cbimwebsocket.global.CBIMWebsocketGlobal.sessionMap;

@Service
public class CompareService {

    private static final Logger logger = LoggerFactory.getLogger(CompareService.class);

    public void proc() {

        logger.info("比较变化包服务开始");


        /**
         * 向前端发送比较变化包
         * */
        sendWebsocket();

    }

    private void sendWebsocket() {

        for (Map.Entry<Session, Boolean> entry : sessionMap.entrySet()) {
            entry.getKey().sendText("变化包发给前端，嘟嘟嘟~~~");
        }

    }
}
