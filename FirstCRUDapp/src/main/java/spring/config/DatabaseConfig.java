package spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseConfig {
    private final String DRIVER_NAME;
    private final String URL;
    private final String NAME;
    private final String PASSWORD;

    public DatabaseConfig(@Value("${driver.name}") String DRIVER_NAME,
                          @Value("${URL}") String URL, @Value("${name}") String NAME,
                          @Value("${password}") String PASSWORD) {
        this.DRIVER_NAME = DRIVER_NAME;
        this.URL = URL;
        this.NAME = NAME;
        this.PASSWORD = PASSWORD;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(NAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setDriverClassName(DRIVER_NAME);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
