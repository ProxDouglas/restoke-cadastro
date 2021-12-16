package com.estoke.web;

import com.estoke.web.config.constant.EstokeProfiles;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vitor.alves
 */
@SpringBootApplication
public class EstokeApplication {

    public static void main(String[] args) {
        EstokeApplication.getApp().run(args);
    }

    public static SpringApplication getApp() {
        SpringApplication application = new SpringApplication(EstokeApplication.class);
        application.setAdditionalProfiles(EstokeProfiles.defaultProfiles());
        return application;
    }
}
