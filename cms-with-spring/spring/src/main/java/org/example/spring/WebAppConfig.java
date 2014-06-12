package org.example.spring;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:/org/example/hipporepository.properties")
@Configuration
public class WebAppConfig {

    @Inject
    Environment env;

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public ListenerRegistrationService getRegistrationService(){
        return new ListenerRegistrationService();
    }

    @Bean(destroyMethod = "destroy")
    public HippoRepositoryService getRepositoryService() {
        return new HippoRepositoryService(
                env.getProperty("repository.location"),
                env.getProperty("repository.username"),
                env.getProperty("repository.password"));
    }

}
