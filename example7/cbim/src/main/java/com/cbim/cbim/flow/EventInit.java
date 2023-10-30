package com.cbim.cbim.flow;

import com.cbim.cbim.enums.ServiceEnums;
import com.cbim.cbim.service.Score.ScoreService;
import com.cbim.cbim.service.user.UserService;
import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import org.springframework.stereotype.Component;

import static com.cbim.flowbase.global.DataGlobal.eventServiceMap;

@Component("eventInit")
public class EventInit extends AbstractActuator {

    public void invoke(ActuatorEntity actuatorEntity) throws Exception {

        eventServiceMap.put(ServiceEnums.SCORE.getCode(), new ScoreService()); // 注册分数服务

        eventServiceMap.put(ServiceEnums.USER.getCode(), new UserService()); // 注册个人信息服务
    }

    ;
}
