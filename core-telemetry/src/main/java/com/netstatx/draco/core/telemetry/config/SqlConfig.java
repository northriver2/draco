package com.netstatx.draco.core.telemetry.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Configuration
public class SqlConfig {
    @Bean(destroyMethod = "close")
    @ConfigurationProperties(prefix = "dataSource")
    public DataSource dataSource(){
        return new HikariDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
