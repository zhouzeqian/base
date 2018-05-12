package com.kxll.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan
public class RedissonConfig {
    @Bean(destroyMethod = "shutdown")
    RedissonClient redisson(@Value("classpath:redisson.json") Resource configFile) throws IOException {
        Config config = Config.fromJSON(configFile.getInputStream());
        return Redisson.create(config);
    }
}
