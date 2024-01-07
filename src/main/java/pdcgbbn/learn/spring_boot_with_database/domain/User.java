package pdcgbbn.learn.spring_boot_with_database.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "PDC_USER")
public class User {

    @Id
    @GeneratedValue(generator="USER_SEQ")
    @SequenceGenerator(name="USER_SEQ",sequenceName="USER_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
}
