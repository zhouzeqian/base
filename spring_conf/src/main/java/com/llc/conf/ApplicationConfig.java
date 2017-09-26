package com.llc.conf;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.llc",excludeFilters ={@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
@EnableTransactionManagement
@Import({DataConfig.class})
public class ApplicationConfig {
    @Bean
    public PropertyPlaceholderConfigurer getTestPpc() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("jdbc.properties"));
        return ppc;
    }

}
