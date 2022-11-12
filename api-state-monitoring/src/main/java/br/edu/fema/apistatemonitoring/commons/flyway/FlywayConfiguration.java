package br.edu.fema.apistatemonitoring.commons.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    @Bean
    public Flyway flyway(DataSource dataSource, @Value("${spring.jpa.database-platform}") String databaseDialect) {
        DatabaseScriptPath databaseScript = DatabaseScriptPath.getByDialect(databaseDialect);

        ClassicConfiguration config = new ClassicConfiguration();
        config.setLocations(new Location(databaseScript.getScriptPath()));
        config.setDataSource(dataSource);
        config.setBaselineOnMigrate(true);

        Flyway flyway = new Flyway(config);
        flyway.migrate();
        return flyway;
    }
}
