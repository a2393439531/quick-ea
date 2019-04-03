package com.glcxw.gateway.config;

import com.glcxw.gateway.service.ZuulRouteService;
import com.glcxw.gateway.core.zuul.CustomRouteLocator;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author aoki
 */
@Configuration
public class CustomZuulConfig {

    @Resource
    ZuulProperties zuulProperties;
    @Resource
    ServerProperties server;
    @Resource
    ZuulRouteService zuulRouteService;

    @Bean
    public CustomRouteLocator routeLocator() {
        CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServlet().getContextPath(), this.zuulProperties);
        routeLocator.setZuulRouteService(zuulRouteService);
        return routeLocator;
    }

}
