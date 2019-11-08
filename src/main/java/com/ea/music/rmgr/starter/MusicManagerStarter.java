package com.ea.music.rmgr.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.ea.music")
public class MusicManagerStarter {

    public static void main(String[] args) {
    	System.setProperty("server.servlet.context-path", "/app");
    	System.setProperty("server.port", "8091");
        SpringApplication.run(MusicManagerStarter.class, args);
    }

}

