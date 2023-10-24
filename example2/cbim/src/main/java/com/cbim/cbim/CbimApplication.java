package com.cbim.cbim;

import com.cbim.flow.chain.Chain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication
@ComponentScan(nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class, basePackages = {"com.cbim.cbim", "com.cbim.flow", "com.cbim.sourcetool", "com.cbim.sourcebase"
,"com.cbim.sourcenetty"})
public class CbimApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CbimApplication.class, args);

        Chain chain = new Chain();
        chain.run();
    }

}
