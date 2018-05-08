package com.llc.conf;

import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
@Configuration
@ComponentScan
@EnableCaching
public class RedissonConfig {
	@Bean(destroyMethod = "shutdown")
	RedissonClient redisson(@Value("classpath:redisson.json") Resource configFile) throws IOException {
		Config config = Config.fromJSON(configFile.getInputStream());
		return Redisson.create(config);
	}

}
