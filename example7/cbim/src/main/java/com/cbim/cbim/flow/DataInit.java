package com.cbim.cbim.flow;

import com.cbim.cbim.entity.Model.user.AccountModelEntity;
import com.cbim.cbim.mapper.ModerMapper;
import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dataInit")
public class DataInit extends AbstractActuator {

    private static final Logger logger = LoggerFactory.getLogger(DataInit.class);

    @Autowired
    private ModerMapper moderMapper;

    public void invoke(ActuatorEntity actuatorEntity) throws Exception{

        scoreServiceInit();

        userServiceInit();

    }

    public void scoreServiceInit(){
        /*
        * 初始化 ScoreService 所需的服务
        * */
    }

    public void userServiceInit(){

        List<AccountModelEntity> accountModelEntityList = moderMapper.getAccount();

        System.out.println(accountModelEntityList);
    }
}
