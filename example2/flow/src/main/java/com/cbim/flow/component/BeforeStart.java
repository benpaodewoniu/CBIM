package com.cbim.flow.component;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import org.springframework.stereotype.Component;

@Component("beforeStart")
public class BeforeStart extends AbstractActuator {

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
    }

    ;

}
