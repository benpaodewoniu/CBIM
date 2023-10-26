package com.cbim.flowbase.entity;

import lombok.Data;

import java.util.Map;

@Data
public class ActuatorEntity {
    private Map<String, Object> paramMap;
    private Map<String, Object> resultMap;
}
