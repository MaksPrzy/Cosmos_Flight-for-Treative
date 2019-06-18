package pl.przybylo.flights.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightNewDto {

    private String name;
    private PlaceWithDateDto departure;
    private PlaceWithDateDto arrival;
    private Integer sitCount;
    private BigDecimal ticketPrice;

}
