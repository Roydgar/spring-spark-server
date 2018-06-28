package tk.roydgar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.impl.ClientDaoJDBC;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:dao/connectionConfig.properties")
public class DatabaseConfig {

    @Autowired
    Environment environment;

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("db.local.url"));
        dataSource.setUsername(environment.getProperty("db.local.user"));
        dataSource.setPassword(environment.getProperty("db.local.password"));
        dataSource.setDriverClassName(environment.getProperty("db.driver"));

        return dataSource;
    }

}
