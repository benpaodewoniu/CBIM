package com.cbim.cbim.service.compare;

import com.cbim.cbim.proto.CbiMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.yeauty.pojo.Session;

import java.util.Map;

import static com.cbim.cbim.global.ServiceGlobal.scoreInfoEntityList;
import static com.cbim.cbimwebsocket.global.CBIMWebsocketGlobal.sessionMap;

@Service
public class CompareService {

    CbiMsg.MsgProto.Builder cbiBuilder = CbiMsg.MsgProto.newBuilder();

    private static final Logger logger = LoggerFactory.getLogger(CompareService.class);

    public void proc() {

        logger.info("比较变化包服务开始");

        /**
         * 构造 score protobuf 数据，发送到前端
         * */
        compareScore();


        /**
         * 向前端发送比较变化包
         * */
        sendWebsocket();

    }

    private void compareScore() {

        CbiMsg.ScoreProtoList.Builder scoreProtoList = CbiMsg.ScoreProtoList.newBuilder();


        for (int i = 0; i < scoreInfoEntityList.size(); i++) {
            CbiMsg.ScoreProto.Builder scoreBuilder = CbiMsg.ScoreProto.newBuilder();
            scoreBuilder.setName(scoreInfoEntityList.get(i).getName());
            scoreBuilder.setChinese(scoreInfoEntityList.get(i).getChinese());
            scoreBuilder.setMath(scoreInfoEntityList.get(i).getMath());
            scoreBuilder.setEnglish(scoreInfoEntityList.get(i).getEnglish());
            scoreProtoList.addList(scoreBuilder);
        }

        cbiBuilder.setScoreList(scoreProtoList);

    }

    private void sendWebsocket() {

        for (Map.Entry<Session, Boolean> entry : sessionMap.entrySet()) {
            entry.getKey().sendBinary(cbiBuilder.build().toByteArray());
        }

    }
}
