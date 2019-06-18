package pl.przybylo.flights.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightViewDto {

    private Long id;
    private String name;
    private PlaceWithDateDto departure;
    private PlaceWithDateDto arrival;
    private Integer sitCount;
    private Integer touristCount;
    private BigDecimal ticketPrice;
    private List<TouristViewDto> tourists;

}
