package com.cbim.cbim;

import com.cbim.flow.chain.Chain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CbimApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbimApplication.class, args);

        Chain chain = new Chain();
        chain.run(null);
    }

}
