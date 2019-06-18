package pl.przybylo.flights.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.przybylo.flights.domain.Flight;
import pl.przybylo.flights.domain.PlaceWithDate;
import pl.przybylo.flights.dto.FlightNewDto;
import pl.przybylo.flights.dto.FlightViewDto;
import pl.przybylo.flights.dto.PlaceWithDateDto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class FlightMapper {

    private final TouristMapper touristMapper;

    public Flight map(FlightNewDto flightNewDto) {
        return new Flight(
                flightNewDto.getName(),
                map(flightNewDto.getDeparture()),
                map(flightNewDto.getArrival()),
                flightNewDto.getSitCount(),
                flightNewDto.getTicketPrice()
        );
    }

    public List<FlightViewDto> map(Collection<Flight> flights) {
        if (isNull(flights)) {
            return newArrayList();
        }

        return flights.stream()
                .filter(f -> !f.isRemoved())
                .map(f -> map(f))
                .collect(toList());
    }

    public FlightViewDto map(Flight flight) {
        if (isNull(flight)) {
            return null;
        }

        return new FlightViewDto(
                flight.getId(),
                flight.getName(),
                map(flight.getDeparture()),
                map(flight.getArrival()),
                flight.getSitCount(),
                flight.getTouristCount(),
                flight.getTicketPrice(),
                touristMapper.map(flight.getTourists().stream()
                        .filter(t -> !t.isRemoved())
                        .collect(Collectors.toList()))
        );
    }

    private PlaceWithDate map(PlaceWithDateDto placeWithDateDto) {
        return new PlaceWithDate(
                placeWithDateDto.getPlace(),
                placeWithDateDto.getDateTime()
        );
    }

    private PlaceWithDateDto map(PlaceWithDate placeWithDate) {
        if (isNull(placeWithDate)) {
            return null;
        }

        return new PlaceWithDateDto(
                placeWithDate.getPlace(),
                placeWithDate.getDateTime()
        );
    }

}
