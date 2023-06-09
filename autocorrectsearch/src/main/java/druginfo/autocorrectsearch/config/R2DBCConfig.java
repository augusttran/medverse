package druginfo.autocorrectsearch.config;

import druginfo.autocorrectsearch.constants.PGauthentication;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
public class R2DBCConfig extends AbstractR2dbcConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(DRIVER, PGauthentication.drivername)
                        .option(PROTOCOL, PGauthentication.protocolPsql)
                        .option(HOST, PGauthentication.lcHost)
                        .option(USER, PGauthentication.pgUsername)
                        .option(PASSWORD, PGauthentication.pgPwd)
                        .option(DATABASE, PGauthentication.drugbankDB)
                        .build());
    }
}

