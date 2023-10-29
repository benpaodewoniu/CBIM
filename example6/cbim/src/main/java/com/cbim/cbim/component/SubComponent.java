package com.cbim.cbim.component;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcenetty.client.ClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cbim.flowbase.global.FlowGlobal.flowMapAbstractActuator;
import static com.cbim.sourcebase.sourceGlobal.SourceGlobal.dataQueue;

public class SubComponent {

    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    public void run() throws Exception {

        while (true) {
            try {
                if (!dataQueue.isEmpty()) {
                    proc();
                } else {
                    Thread.sleep(50);
                }
            } catch (Exception e) {
                logger.error(e.toString());
            }
        }


    }

    public void proc() throws Exception {

        ActuatorEntity actuatorEntity = new ActuatorEntity();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("data", dataQueue.poll());
        actuatorEntity.setParamMap(paramMap);

        List<AbstractActuator> abstractActuatorList = flowMapAbstractActuator.get("sub");
        for (AbstractActuator abstractActuator : abstractActuatorList) {
            abstractActuator.invoke(actuatorEntity);
        }
    }
}
