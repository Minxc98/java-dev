package org.example.database;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class FlywayConfig {

    private final DataSource dataSource;
    private final DataSourceProperties dataSourceProperties;

    @Autowired
    public FlywayConfig(DataSource dataSource, DataSourceProperties dataSourceProperties) {
        this.dataSource = dataSource;
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public FlywayProperties flywayProperties() {
        return new FlywayProperties();
    }

    @PostConstruct
    public void migrate() throws SQLException {
        String username = dataSourceProperties.getUsername();
        String password = dataSourceProperties.getPassword();
        String url = dataSourceProperties.getUrl();

        // MySQL数据库连接的url
        String connectUrl = url.substring(0, url.lastIndexOf("/"));
        // 数据库名
        String database = url.substring(url.lastIndexOf("/") + 1);
        // 创建数据库的SQL
        String sql = "create database if not exists " + database + " DEFAULT CHARSET utf8mb4";

        // 创建数据库连接
        Connection connection = DriverManager.getConnection(connectUrl, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        int update = statement.executeUpdate();

        if (update > 0) {
            log.debug("数据库{}不存在，已经完成创建...", database);
        }

        FlywayProperties flywayProperties = flywayProperties();

        if (flywayProperties.isEnabled()) {
            log.debug("FlywayConfig.migrate()方法执行...");

            Flyway flyway = Flyway.configure()
                    .dataSource(dataSource)
                    .locations(flywayProperties.getLocations().toArray(new String[]{}))
                    .baselineOnMigrate(flywayProperties.isBaselineOnMigrate())
                    .load();

            flyway.migrate();
        }
    }

}