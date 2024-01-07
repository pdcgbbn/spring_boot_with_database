package pdcgbbn.learn.spring_boot_with_database.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class HibernateConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driveClassName;

//    @Value("hibernate-config.properties")
//    private Map<String, String> hibernateConfig;


//    @Value("${mail.additionalHeaders}")
//    private Map<String, String> additionalHeaders;

    private final CustomProperty customProperty;



    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(customProperty.getUrl());
        dataSource.setUsername(customProperty.getUserDB());
        dataSource.setPassword(customProperty.getPassword());
        dataSource.setDriverClassName(customProperty.getDriveClassName());

//        System.out.println(additionalHeaders);

        return dataSource;
    }

//    @Bean(name="entityManagerFactory")
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"pdcgbbn.learn.spring_boot_with_database.domain"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(CustomProperty.HIBERNATE_HBM2DDL_AUTO, customProperty.getHbm2ddlAuto());
        hibernateProperties.setProperty(CustomProperty.HIBERNATE_DIALECT, customProperty.getDialect());
        hibernateProperties.setProperty(CustomProperty.HIBERNATE_SHOW_SQL, customProperty.getShowSql());

        return hibernateProperties;
    }
}
