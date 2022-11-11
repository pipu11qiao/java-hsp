package org.example;

import org.example.service.ResourceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ResourceConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ResourceConfig.class);
        ResourceService rs = context.getBean(ResourceService.class);
        System.out.println(rs.logo);
    }
}
