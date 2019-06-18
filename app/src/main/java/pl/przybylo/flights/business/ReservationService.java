package pl.przybylo.flights.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przybylo.flights.domain.Flight;
import pl.przybylo.flights.domain.FlightRepository;
import pl.przybylo.flights.domain.Tourist;
import pl.przybylo.flights.domain.TouristRepository;
import pl.przybylo.flights.dto.FlightViewDto;
import pl.przybylo.flights.dto.TouristNewDto;
import pl.przybylo.flights.mapper.FlightMapper;
import pl.przybylo.flights.mapper.TouristMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final TouristRepository touristRepository;
    private final TouristMapper touristMapper;
    // validator na sprawdzanie czy mozna dodac rezerwacje

    public FlightViewDto reservation(long flightId, TouristNewDto touristNewDto) {
        Tourist tourist = touristRepository.save(touristMapper.map(touristNewDto));

        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException(String.format("Flight with ID %d not found", flightId)));
        flight.getTourists().add(tourist);
        flight.setTouristCount(flight.getTouristCount() + 1);
        flight = flightRepository.save(flight);

        return flightMapper.map(flight);
    }

    public void cancelReservation(Long flightId, Long touristId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));

        if (flight.isRemoved()) {
            throw new FlightAlreadyCancelledException(flightId);
        }

        Optional<Tourist> touristOptional = flight.getTourists().stream()
                .filter(t -> !t.isRemoved())
                .filter(t -> t.getId().equals(touristId))
                .findFirst();

        if (touristOptional.isPresent()) {
            Tourist tourist = touristOptional.get();
            tourist.setRemoved(true);
            flight.setTouristCount(flight.getTouristCount() - 1);
            flightRepository.save(flight);
        } else {
            throw new TouristNotFoundException(touristId);
        }
    }

}
