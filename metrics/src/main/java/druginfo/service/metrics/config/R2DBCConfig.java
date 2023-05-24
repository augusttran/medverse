package druginfo.service.metrics.config;

import druginfo.service.metrics.constant.PGauthentication;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;

@Configuration
public class R2DBCConfig extends AbstractR2dbcConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(DRIVER, PGauthentication.PG_DRIVERNAME)
                        .option(PROTOCOL, PGauthentication.PG_PROTOCOL)
                        .option(HOST, PGauthentication.PG_HOST)
                        .option(USER, PGauthentication.PG_USERNAME)
                        .option(PASSWORD, PGauthentication.PG_PWD)
                        .option(DATABASE, PGauthentication.PG_DBNAME)
                        .build());
    }
}
