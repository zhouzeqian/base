package com.llc.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.io.IOException;
import java.sql.SQLException;

@Configuration
@MapperScan("com.llc.mapper")
public class DataConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.filters}")
    private String filters;
    @Value("${jdbc.maxActive}")
    private Integer maxActive;
    @Value("${jdbc.initialSize}")
    private Integer initialSize;
    @Value("${jdbc.maxWait}")
    private Integer maxWait;
    @Value("${jdbc.minIdle}")
    private Integer minIdle;
    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;
    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;
    @Value("${jdbc.validationQuery}")
    private String validationQuery;
    @Value("${jdbc.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${jdbc.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${jdbc.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${jdbc.maxOpenPreparedStatements}")
    private Integer maxOpenPreparedStatements;
    @Value("${jdbc.removeAbandoned}")
    private Boolean removeAbandoned;
    @Value("${jdbc.removeAbandonedTimeout}")
    private Integer removeAbandonedTimeout;
    @Value("${jdbc.logAbandoned}")
    private Boolean logAbandoned;

    @Bean
    //数据源
    public DruidDataSource dataSource(){
        DruidDataSource dds=new DruidDataSource();
        dds.setUrl(url);
        dds.setDriverClassName(driverClass);
        dds.setUsername(username);
        dds.setPassword(password);
        try {
            dds.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dds.setMaxActive(maxActive);
        dds.setInitialSize(initialSize);
        dds.setMaxWait(maxWait);
        dds.setMinIdle(minIdle);
        dds.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        dds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dds.setValidationQuery(validationQuery);
        dds.setTestWhileIdle(testWhileIdle);
        dds.setTestOnBorrow(testOnBorrow);
        dds.setTestOnReturn(testOnReturn);
        dds.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        dds.setRemoveAbandoned(removeAbandoned);
        dds.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dds.setLogAbandoned(logAbandoned);
        dds.setPoolPreparedStatements(true);
        dds.setMaxPoolPreparedStatementPerConnectionSize(20);
        return dds;
    }

    @Bean
    //事务
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    //扫描
    public SqlSessionFactoryBean getSqlSessionFactory(){
        SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource());
        DefaultResourceLoader resource=new DefaultResourceLoader();
        ssfb.setConfigLocation(resource.getResource("mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            ssfb.setMapperLocations(resolver.getResources("classpath:mapping/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ssfb;
    }

}
