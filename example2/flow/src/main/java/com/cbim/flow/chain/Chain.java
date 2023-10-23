package com.cbim.flow.chain;

import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorContext;
import com.cbim.flowbase.entity.ActuatorEntity;
import com.cbim.flowbase.entity.ActuatorFlowList;
import com.cbim.sourcetool.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.cbim.flowbase.global.FlowGlobal.flowMapAbstractActuator;
import static com.cbim.flowbase.global.FlowGlobal.flowMapConfig;

@Component
public class Chain {

    @Autowired
    private ApplicationContext applicationContext;


    public void run() throws Exception {
        /**
         * 读取责任链的配置
         * */

        readFlow("example2/cbim/config/common/flowConfig.yml");

        /**
         *
         * */
        setFlowAbstractActuator();

        /**
         * 执行责任链的前置模块
         * */
        proc();
    }

    public void readFlow(String path) throws IOException {
        Yaml yaml = new Yaml(new Constructor(ActuatorFlowList.class));
        String configPath = new File("").getCanonicalPath() + File.separator + path;
        InputStream inputStream = new FileInputStream(configPath);
        ActuatorFlowList actuatorFlowList = yaml.load(inputStream);
        actuatorFlowList.getFlow().stream().forEach(s -> flowMapConfig.put(s.getType(), s));
    }

    public void setFlowAbstractActuator() throws Exception {
        for (String key : flowMapConfig.keySet()) {
            List<ActuatorContext> actuatorContextList = flowMapConfig.get(key).getChains();
            List<AbstractActuator> abstractActuatorList = new ArrayList<>();
            for (ActuatorContext actuatorContext : actuatorContextList) {
                abstractActuatorList.add(SpringUtils.getBean(actuatorContext.getBeanName(), AbstractActuator.class));
            }
            flowMapAbstractActuator.put(key, abstractActuatorList);
        }
    }

    public void proc() throws Exception {
        List<AbstractActuator> abstractActuatorList = flowMapAbstractActuator.get("before");
        for (AbstractActuator abstractActuator : abstractActuatorList) {
            abstractActuator.invoke(new ActuatorEntity());
        }
    }
}
