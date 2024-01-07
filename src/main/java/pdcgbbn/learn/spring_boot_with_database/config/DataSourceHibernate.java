package pdcgbbn.learn.spring_boot_with_database.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSourceHibernate {

    private final CustomProperty customProperty;
}
