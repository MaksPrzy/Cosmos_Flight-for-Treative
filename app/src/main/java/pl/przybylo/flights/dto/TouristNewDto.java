package pl.przybylo.flights.dto;

import lombok.Data;
import pl.przybylo.flights.domain.Sex;

import java.time.LocalDate;

@Data
public class TouristNewDto extends AbstractTouristDto {

    public TouristNewDto() {
        super();
    }

    public TouristNewDto(String firstName, String lastName, Sex sex, String country, String note, LocalDate birthDate) {
        super(firstName, lastName, sex, country, note, birthDate);
    }

}
