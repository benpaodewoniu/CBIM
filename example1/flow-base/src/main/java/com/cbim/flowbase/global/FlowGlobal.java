package com.cbim.flowbase.global;

import com.cbim.flowbase.entity.ActuatorFlowList;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FlowGlobal {
    private static List<ActuatorFlowList> flowListConfig = new ArrayList<>();
}
