package com.cbim.cbim.flow;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import org.springframework.stereotype.Component;

@Component("dataInit")
public class DataInit extends AbstractActuator {

    public void invoke(ActuatorEntity actuatorEntity) throws Exception{

        scoreServiceInit();

    }

    public void scoreServiceInit(){
        /*
        * 初始化 ScoreService 所需的服务
        * */
    }
}
