package com.cbim.flow.factory;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcebase.entity.combine.CombineConfig;
import com.cbim.sourcebase.entity.combine.CombineConfigList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.cbim.flowbase.global.FlowGlobal.*;

@Component("combineFactory")
public class CombineFactory extends AbstractActuator {

    private static final Logger logger = LoggerFactory.getLogger(CombineFactory.class);

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        logger.info("组合程序调用成功");

        for (String key : combineConfigListHashMap.keySet()) {

            CombineConfigList combineConfigList = combineConfigListHashMap.get(key);

            String type = combineConfigList.getType();
            StringBuilder stringBuilder = new StringBuilder();

            for (CombineConfig combineConfig : combineConfigList.getContent()) {
                String typeSub = combineConfig.getType();
                String value = analyseDataHashMap.get(typeSub);
                stringBuilder.append(value + ",");
            }

            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }

            combineDataHashMap.put(type, stringBuilder.toString());

        }

        logger.info(combineDataHashMap.get("11"));

    }


    ;

}