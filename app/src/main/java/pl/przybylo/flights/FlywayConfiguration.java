package pl.przybylo.flights;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static pl.przybylo.flights.Profile.DROP_DB;

@Configuration
public class FlywayConfiguration {

    @Bean
    @Profile(DROP_DB)
    public FlywayMigrationStrategy clean() {
        return (flyway) -> {
            flyway.clean();
            flyway.migrate();
        };
    }

}
