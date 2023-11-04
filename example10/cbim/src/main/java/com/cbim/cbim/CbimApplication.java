package com.cbim.cbim;

import com.cbim.cbim.component.InitComponent;
import com.cbim.flow.chain.Chain;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan(nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class, basePackages = {"com.cbim.cbim", "com.cbim.flow", "com.cbim.sourcetool", "com.cbim.sourcebase"
        , "com.cbim.sourcenetty", "com.cbim.sourceanalyse", "com.cbim.cbimwebsocket"})
@MapperScan({"com.cbim.cbim.mapper"})
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

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
            factory.addErrorPages(error404Page);
        };
    }

}
