package com.cbim.flow.factory;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.flowbase.interfaces.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.cbim.flowbase.global.DataGlobal.eventServiceMap;
import static com.cbim.flowbase.global.FlowGlobal.combineDataHashMap;

@Component("callEventFactory")
public class CallEventFactory extends AbstractActuator {
    private static final Logger logger = LoggerFactory.getLogger(CallEventFactory.class);


    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {

        for (String key : eventServiceMap.keySet()) {

            try {
                EventService eventService = eventServiceMap.get(key);
                String data = combineDataHashMap.get(key);
                eventService.update(data);
            } catch (Exception e) {
                logger.error(e.toString());
            }

        }

    }

    ;

}
