package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppConfig {

    @Bean
    public HelloService getHello(){
        final HelloServiceImpl helloService = new HelloServiceImpl();
        helloService.setGlobalMessage("Hello World");
        return helloService;
    }
}
