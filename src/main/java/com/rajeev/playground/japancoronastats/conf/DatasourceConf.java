package com.rajeev.playground.japancoronastats.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConf {

    @Primary
    @Bean(value = "dataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(value = "datasource")
    public DataSource getDataSource(@Qualifier("dataSourceProperties") DataSourceProperties dataSourceProperties) {
        System.out.println(dataSourceProperties.getDriverClassName());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
