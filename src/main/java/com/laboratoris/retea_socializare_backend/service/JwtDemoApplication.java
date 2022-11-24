package com.laboratoris.retea_socializare_backend.service;

import com.laboratoris.retea_socializare_backend.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class JwtDemoApplication {
    public static void main(String[] args){
        SpringApplication.run(JwtDemoApplication.class,args);
    }
}
