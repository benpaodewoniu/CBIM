package com.cbim.flowbase.global;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorFlow;
import com.cbim.sourcebase.entity.analyse.AnalyseConfigList;
import com.cbim.sourcebase.entity.combine.CombineConfigList;
import com.cbim.sourcebase.entity.cut.CutConfig;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class FlowGlobal {
    /*
     * 责任链数据
     * */
    public static Map<String, ActuatorFlow> flowMapConfig = new HashMap<>();
    public static Map<String, List<AbstractActuator>> flowMapAbstractActuator = new HashMap<>();

    /*
     * 切包数据
     * */
    public static Map<String, CutConfig> cutMapConfig = new HashMap<>();
    public static Map<String, byte[]> cutMapData = new HashMap<>();

    /*
     *解析数值
     **/
    public static Map<String, AnalyseConfigList> analyseConfigListHashMap = new HashMap<>();
    public static Map<String, String> analyseDataHashMap = new HashMap<>();

    /*
     *组合数据
     **/
    public static Map<String, CombineConfigList> combineConfigListHashMap = new HashMap<>();
    public static Map<String, String> combineDataHashMap = new HashMap<>();

}
