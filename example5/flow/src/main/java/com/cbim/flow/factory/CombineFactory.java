package com.cbim.flow.factory;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcenetty.client.ClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("combineFactory")
public class CombineFactory extends AbstractActuator {

    private static final Logger logger = LoggerFactory.getLogger(CombineFactory.class);

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        logger.info("调用成功");
    }

    ;

}