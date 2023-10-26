package com.cbim.cbim.component;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;

import java.util.List;

import static com.cbim.flowbase.global.FlowGlobal.flowMapAbstractActuator;

public class InitComponent {
    public void run() throws Exception {
        proc();
    }

    public void proc() throws Exception {
        List<AbstractActuator> abstractActuatorList = flowMapAbstractActuator.get("init");
        for (AbstractActuator abstractActuator : abstractActuatorList) {
            abstractActuator.invoke(new ActuatorEntity());
        }
    }
}
