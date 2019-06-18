package pl.przybylo.flights.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceWithDateDto {

    private String place;
    private LocalDateTime dateTime;

}
