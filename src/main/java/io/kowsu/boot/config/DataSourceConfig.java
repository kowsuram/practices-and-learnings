package io.kowsu.boot.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    @created March/22/2024 - 7:12 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/

@Configuration
public class DataSourceConfig {

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/db.sql'");
        config.setUsername("sa");
        config.setPassword("sa");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("minimumPoolSize", "1");
        config.addDataSourceProperty("maximumPoolSize", "3");
        config.addDataSourceProperty("connectionTimeout", "1000");
        return new HikariDataSource(config);
    }
}
