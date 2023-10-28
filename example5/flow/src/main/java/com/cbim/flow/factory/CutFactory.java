package com.cbim.flow.factory;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourcebase.entity.cut.CutConfig;
import com.cbim.sourcenetty.client.ClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cbim.flowbase.global.FlowGlobal.cutMapConfig;
import static com.cbim.flowbase.global.FlowGlobal.cutMapData;

@Component("cutFactory")
public class CutFactory extends AbstractActuator {

    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        logger.info("使用配置切分原始数据");
        Map<String, Object> paramMap = actuatorEntity.getParamMap();
        byte[] originData = (byte[]) paramMap.get("data");

        for (String key : cutMapConfig.keySet()) {
            CutConfig cutConfig = cutMapConfig.get(key);
            int offset = cutConfig.getOffset();
            int size = cutConfig.getSize();

            byte[] data = new byte[size];

            System.arraycopy(originData, offset, data, 0, size);
            cutMapData.put(key, data);
        }
    }

    ;

}