//package com.midas.market.config.security;
//
//import jakarta.servlet.annotation.WebServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class H2ConsoleConfig{
//    @Bean
//    public ServletRegistrationBean h2Console() {
//        String path = "/h2-console/*";
//        String urlMapping = "/h2-console/**";
//
//        // Allow access to H2 console
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet(), urlMapping);
//        servletRegistrationBean.addInitParameter("webAllowOthers", "true");
//        servletRegistrationBean.addUrlMappings(path);
//
//        return servletRegistrationBean;
//    }
//}
