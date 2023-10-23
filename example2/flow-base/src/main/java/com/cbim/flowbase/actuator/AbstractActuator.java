package com.cbim.flowbase.actuator;

import com.cbim.flowbase.entity.ActuatorEntity;
import lombok.Data;

@Data
public abstract class AbstractActuator {
    public abstract void invoke(ActuatorEntity actuatorEntity) throws Exception;
}
