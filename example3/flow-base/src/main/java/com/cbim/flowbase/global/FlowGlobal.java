package com.cbim.flowbase.global;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorFlow;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class FlowGlobal {
    public static Map<String, ActuatorFlow> flowMapConfig = new HashMap<>();
    public static Map<String, List<AbstractActuator>> flowMapAbstractActuator = new HashMap<>();
}
