package com.cbim.flow.component;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcenetty.client.NettyClient;
import org.springframework.stereotype.Component;

@Component("clientFactory")
public class ClientFactory extends AbstractActuator {

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        Runnable runnable = new NettyClient();
        runnable.run();

    }

    ;

}
