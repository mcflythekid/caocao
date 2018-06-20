package com.beathim.caocao.db;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = { "com.beathim.caocao.db" })
@EnableJpaRepositories({ "com.beathim.caocao.db" })
@EnableTransactionManagement
@PropertySource("classpath:caocao.properties")
public class Config {

    private @Value("${spring.source.url}") String url;
    private @Value("${spring.source.username}") String username;
    private @Value("${spring.source.password}") String password;
    private @Value("${spring.source.driver-class-name}") String driverClassName;
    private @Value("${spring.source.pool-size}") Integer poolSize;
    private @Value("${spring.source.dialect}") String dialect;

    private HikariDataSource dataSource() {
        HikariDataSource o = new HikariDataSource();
        o.setJdbcUrl(String.format(url));
        o.setUsername(username);
        o.setPassword(password);
        o.setMaximumPoolSize(poolSize);
        o.setDriverClassName(driverClassName);
        return o;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPackagesToScan("com.beathim.caocao.db");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.hbm2ddl.auto","validate");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.format_sql", "true");
        bean.setJpaProperties(properties);
        bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return bean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager bean = new JpaTransactionManager();
        bean.setEntityManagerFactory(entityManagerFactory().getObject());
        return bean;
    }
}
