package com.cbim.cbim.component;

import com.cbim.cbim.service.compare.CompareService;
import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcenetty.client.ClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("endHandler")
public class EndComponent extends AbstractActuator {

    private static final Logger logger = LoggerFactory.getLogger(EndComponent.class);

    @Autowired
    private CompareService compareService;

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        compareService.proc();
    }
}
