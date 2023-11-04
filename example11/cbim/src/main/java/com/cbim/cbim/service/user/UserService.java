package com.cbim.cbim.service.user;

import com.cbim.cbim.entity.model.history.HistoryModelEntity;
import com.cbim.flowbase.interfaces.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.cbim.cbim.global.ServiceGlobal.accountModelGlobalEntityList;
import static com.cbim.cbim.global.ServiceGlobal.historyModelEntityConcurrentLinkedDeque;

@Service
public class UserService implements EventService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public void update(String data) throws Exception {

        logger.info("数据库输出为" + accountModelGlobalEntityList.toString());

        logger.info("将小明的名字改为小红");

        accountModelGlobalEntityList.get(0).setName("小红");

        /**
         * 添加 history 数据
         * */
        HistoryModelEntity historyModelEntity = new HistoryModelEntity();
        historyModelEntity.setName("小王");
        historyModelEntity.setTime(new Date());
        historyModelEntityConcurrentLinkedDeque.offer(historyModelEntity);

    }
}
