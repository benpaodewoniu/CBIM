package com.cbim.cbim.service.user;

import com.cbim.flowbase.interfaces.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cbim.cbim.global.ServiceGlobal.accountModelGlobalEntityList;

public class UserService implements EventService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public void update(String data) throws Exception {

        logger.info("数据库输出为" + accountModelGlobalEntityList.toString());

    }
}
