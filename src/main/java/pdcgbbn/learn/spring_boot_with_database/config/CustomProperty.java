package pdcgbbn.learn.spring_boot_with_database.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties
@Data
public class CustomProperty {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userDB;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driveClassName;

//    @Value("hibernate-config.properties")
//    private Map<String, String> hibernateConfig;

    @Value("${hibernate-config.properties.hibernate.dialect}")
    private String dialect;

    @Value("${hibernate-config.properties.hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${hibernate-config.properties.hibernate.show_sql}")
    private String showSql;

    public static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    public static final String HIBERNATE_DIALECT = "hibernate.dialect";
    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";

}
