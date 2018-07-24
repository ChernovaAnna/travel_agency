package com.epam.agency.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Configure application context for production.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Configuration
@Profile("production")
@ComponentScan(value = {"com.epam.agency.service", "com.epam.agency.repository"})
@PropertySource(value = {"classpath:db.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    /**
     * Initialize dataSource to postgreSQL database
     *
     * @return initialized dataSource object
     */
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(environment.getRequiredProperty("driver"));
        config.setJdbcUrl(environment.getRequiredProperty("url"));
        config.setUsername(environment.getRequiredProperty("user"));
        config.setPassword(environment.getRequiredProperty("password"));
        return new HikariDataSource(config);
    }

    /**
     *
     * @param dataSource to postgreSQL database
     * @return jdbcTemplate object
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
}
