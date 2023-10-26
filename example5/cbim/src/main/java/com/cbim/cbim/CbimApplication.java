package com.cbim.cbim;

import com.cbim.cbim.component.InitComponent;
import com.cbim.flow.chain.Chain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class, basePackages = {"com.cbim.cbim", "com.cbim.flow", "com.cbim.sourcetool", "com.cbim.sourcebase"
        , "com.cbim.sourcenetty"})
public class CbimApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CbimApplication.class, args);

        /*
         * 责任链初始化，并执行 before
         * */
        Chain chain = new Chain();
        chain.run();

        /*
         * 执行责任链的 Init 模块，并开启 sub 模块
         * */

        InitComponent initComponent = new InitComponent();
        initComponent.run();
    }

}
