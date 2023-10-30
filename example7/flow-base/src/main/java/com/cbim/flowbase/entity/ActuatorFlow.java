package com.cbim.flowbase.entity;

import lombok.Data;

import java.util.List;

@Data
public class ActuatorFlow {
    private String type;
    private List<ActuatorContext> chains;
}
