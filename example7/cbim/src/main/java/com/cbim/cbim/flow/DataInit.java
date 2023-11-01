package com.cbim.cbim.flow;

import com.cbim.cbim.mapper.ModelMapper;
import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.cbim.cbim.global.ServiceGlobal.accountModelGlobalEntityList;

@Component("dataInit")
public class DataInit extends AbstractActuator {

    private static final Logger logger = LoggerFactory.getLogger(DataInit.class);

    @Autowired
    private ModelMapper modelMapper;

    public void invoke(ActuatorEntity actuatorEntity) throws Exception {

        scoreServiceInit();

        userServiceInit();

    }

    public void scoreServiceInit() {
        /*
         * 初始化 ScoreService 所需的服务
         * */
    }

    public void userServiceInit() {
        accountModelGlobalEntityList = modelMapper.getAccount();
    }
}
