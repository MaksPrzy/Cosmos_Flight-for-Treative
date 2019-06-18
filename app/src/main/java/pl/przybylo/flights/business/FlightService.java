package pl.przybylo.flights.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przybylo.flights.domain.Flight;
import pl.przybylo.flights.domain.FlightRepository;
import pl.przybylo.flights.dto.FlightNewDto;
import pl.przybylo.flights.dto.FlightViewDto;
import pl.przybylo.flights.mapper.FlightMapper;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public List<FlightViewDto> getFlights() {
        List<Flight> flights = newArrayList(flightRepository.findAll());
        return flightMapper.map(flights);
    }

    public FlightViewDto add(FlightNewDto flightNewDto) {
//        flightValidator.check(flightNewDto);
        Flight flight = flightMapper.map(flightNewDto);
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.map(savedFlight);
    }

    public void cancel(Long flightId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
        flight.setRemoved(true);
        flightRepository.save(flight);
    }

}
