package com.app.statistics.configuration;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.app.statistics.repository")
@PropertySource(value = {"classpath:database.properties"})
public class SpringMongoConfig extends AbstractMongoConfiguration {
    private static final String BASE_MAPPING_PACKAGE = "com.app.statistics";
    private static final String DB_NAME_PROPERTY = "jdbc.dbName";
    private static final String DB_HOST = "jdbc.host";
    private static final String DB_PORT = "jdbc.port";

    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getProperty(DB_NAME_PROPERTY);
    }

    @Override
    public Mongo mongo() {
        return new MongoClient(env.getProperty(DB_HOST), env.getProperty(DB_PORT, Integer.class));
    }

    @Override
    protected String getMappingBasePackage() {
        return BASE_MAPPING_PACKAGE;
    }

    @Override
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}