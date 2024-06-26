package com.fontolan.springoutboxexample.configurations;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SqlServerConfig {
    private final DomainConfig domainConfig;

    public SqlServerConfig(DomainConfig domainConfig) {
        this.domainConfig = domainConfig;
    }

    @Bean
    @Primary
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url(domainConfig.sqlServerUrl)
                .username(domainConfig.sqlServerUsername)
                .password(domainConfig.sqlServerPassword)
                .driverClassName(domainConfig.sqlServerDriver)
                .build();
    }
}
