package pl.przybylo.flights.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tourists")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String country;

    @Column(columnDefinition = "text")
    private String note;

    private LocalDate birthDate;

    private boolean removed;

    public Tourist() {
        this.sex = Sex.MALE;
        this.removed = false;
    }

    public Tourist(String firstName, String lastName, Sex sex, String country, String note, LocalDate birthDate) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.country = country;
        this.note = note;
        this.birthDate = birthDate;
    }

}
