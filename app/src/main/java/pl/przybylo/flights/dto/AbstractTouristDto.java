package pl.przybylo.flights.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.przybylo.flights.domain.Sex;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractTouristDto {

    protected String firstName;
    protected String lastName;
    protected Sex sex;
    protected String country;
    protected String note;
    protected LocalDate birthDate;

}
