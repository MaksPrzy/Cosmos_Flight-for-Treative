package pl.przybylo.flights.dto;

import lombok.Data;
import pl.przybylo.flights.domain.Sex;

import java.time.LocalDate;

@Data
public class TouristViewDto extends AbstractTouristDto {

    private Long id;

    public TouristViewDto(Long id, String firstName, String lastName, Sex sex, String country, String note, LocalDate birthDate) {
        super(firstName, lastName, sex, country, note, birthDate);
        this.id = id;
    }

}
