package com.fabio.springmvc.config;


import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean h2Console(){
        String path = "/console";
        String urlMapping = (path.endsWith("/")?path+"*":path+"/*");
        return new ServletRegistrationBean(new WebServlet(), urlMapping);
    }

}
