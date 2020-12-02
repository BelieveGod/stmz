package com.stmz.mgr.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/11/19 13:10
 */
//@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .exposedHeaders("Access-Control-Allow-Headers",
                                "Access-control-allow-methods",
                                "Access-control-allow-origin",
                                "Access-control-max-age",
                                "X-Frame-Options")
                .allowedHeaders("*");
    }
}
