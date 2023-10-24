package com.cbim.flow.component;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcenetty.client.NettyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.reactor.netty.ReactorNettyConfigurations;
import org.springframework.stereotype.Component;

@Component("clientFactory")
public class ClientFactory extends AbstractActuator {

    @Autowired
    public NettyClient nettyClient;

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        nettyClient.start();

    }

    ;

}
