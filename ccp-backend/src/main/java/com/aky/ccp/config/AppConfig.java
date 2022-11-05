package com.aky.ccp.config;

import com.aky.ccp.service.CcpService;
import com.aky.ccp.validation.CreditCardValidator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public CreditCardValidator creditCardValidator(){
        return new CreditCardValidator();
    }

    @Bean
    public CcpService ccpService(JdbcTemplate jdbcTemplate){
        return new CcpService(jdbcTemplate);
    }
}
