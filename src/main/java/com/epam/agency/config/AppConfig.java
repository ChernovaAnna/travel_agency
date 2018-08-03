package com.epam.agency.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Configure application context for production.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Configuration
@ComponentScan(value = {"com.epam.agency.service", "com.epam.agency.repository" })
@PropertySource(value = {"classpath:db.properties" })
@EnableTransactionManagement
@Profile("production")
public class AppConfig {
    @Autowired
    private Environment environment;

    /**
     * Initialize dataSource to postgreSQL database
     *
     * @return initialized dataSource object
     */
    @Bean
    @Profile({"jdbcRepository", "jpaRepository" })
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(environment.getRequiredProperty("driver"));
        config.setJdbcUrl(environment.getRequiredProperty("url"));
        config.setUsername(environment.getRequiredProperty("user"));
        config.setPassword(environment.getRequiredProperty("password"));
        return new HikariDataSource(config);
    }

    @Bean
    @Profile("jpaRepository")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em =
                new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.epam.agency.domain");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Bean
    @Profile("jpaRepository")
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", true);
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    /**
     * @param dataSource to embedded database
     * @return jdbcTemplate object
     */
    @Bean
    @Profile("jdbcRepository")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }


}
