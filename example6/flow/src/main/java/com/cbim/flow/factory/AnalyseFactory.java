package com.cbim.flow.factory;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.sourceanalyse.analyse.AnalyseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("analyseFactory")
public class AnalyseFactory extends AbstractActuator {

    @Autowired
    private AnalyseService analyseService;
    private static final Logger logger = LoggerFactory.getLogger(AnalyseFactory.class);

    @Override
    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        /*
         * 为了方便，没用工厂类判断
         * */
        logger.info("使用配置解析原始数据");
        analyseService.invoke(actuatorEntity);
    }

}