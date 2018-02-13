package com.app.statistics.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.app.statistics.repository"})
@EnableTransactionManagement
@PropertySource(value = { "classpath:database.properties" })
public class SpringDatabaseConfiguration {
    private static final String JDBC_DRIVER_CLASS_NAME_PROPERTY = "jdbc.driverClassName";
    private static final String JDBC_URL_PROPERTY = "jdbc.url";
    private static final String JDBC_USERNAME_PROPERTY = "jdbc.username";
    private static final String JDBC_PASSWORD_PROPERTY = "jdbc.password";

    private static final String PATH_TO_ENTITY_FOLDER = "com.app.statistics.entity";

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(JDBC_DRIVER_CLASS_NAME_PROPERTY));
        dataSource.setUrl(env.getProperty(JDBC_URL_PROPERTY));
        dataSource.setUsername(env.getProperty(JDBC_USERNAME_PROPERTY));
        dataSource.setPassword(env.getProperty(JDBC_PASSWORD_PROPERTY));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setGenerateDdl(true);
        adapter.setShowSql(true);

        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setPackagesToScan(PATH_TO_ENTITY_FOLDER);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }


}