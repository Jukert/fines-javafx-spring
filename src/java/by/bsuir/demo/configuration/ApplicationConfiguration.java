package by.bsuir.demo.configuration;

import by.bsuir.demo.dao.FineDao;
import by.bsuir.demo.dao.impl.FineDaoImpl;
import by.bsuir.demo.dao.impl.JdbcDaoTemplate;
import by.iba.sql.database.impl.MySQLBase;
import by.iba.sql.factory.SqlBuilderFactory;
import by.iba.sql.factory.impl.SqlBuilderFactoryImpl;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FineDao fineDao() {
        SqlBuilderFactory sqlBuilderFactory = new SqlBuilderFactoryImpl(
                new MySQLBase());
        return new FineDaoImpl(jdbcDaoTemplate(), sqlBuilderFactory);
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.demo")
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .build();

    }

    @Bean
    public JdbcDaoTemplate jdbcDaoTemplate() {
        return new JdbcDaoTemplate(dataSource());
    }

}
