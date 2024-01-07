package pdcgbbn.learn.spring_boot_with_database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pdcgbbn.learn.spring_boot_with_database.config.CustomProperty;

@SpringBootApplication
@EnableConfigurationProperties({CustomProperty.class})
public class SpringBootWithDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithDatabaseApplication.class, args);
    }

}
