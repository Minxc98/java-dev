package org.example.database.config;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.datasource.FlexDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class FlywayConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        FlexDataSource flexDataSource = FlexGlobalConfig.getDefaultConfig()
                .getDataSource();
        Map<String, DataSource> dataSourceMap = flexDataSource.getDataSourceMap();

        dataSourceMap.forEach((k,v)->{
            Flyway flyway = Flyway.configure()
                    .dataSource(v)
                    .locations("classpath:db/"+k+"/")
                    .load();
            flyway.migrate();
        });
    }
}
