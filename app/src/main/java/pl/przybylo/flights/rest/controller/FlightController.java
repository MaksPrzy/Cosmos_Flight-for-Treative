package pl.przybylo.flights.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.przybylo.flights.business.FlightService;
import pl.przybylo.flights.business.ReservationService;
import pl.przybylo.flights.dto.FlightNewDto;
import pl.przybylo.flights.dto.FlightViewDto;
import pl.przybylo.flights.dto.TouristNewDto;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;
    private final ReservationService reservationService;

    @GetMapping("/flights")
    public Collection<FlightViewDto> getFlights() {
        return flightService.getFlights();
    }

    @PostMapping("/flights")
    public FlightViewDto addFlight(@RequestBody FlightNewDto flightNewDto) {
        return flightService.add(flightNewDto);
    }

    @PostMapping("/flights/{flightId}")
    public FlightViewDto reservation(@PathVariable Long flightId, @RequestBody TouristNewDto touristNewDto) {
        return reservationService.reservation(flightId, touristNewDto);
    }

    @DeleteMapping("/flights/{flightId}")
    public void cancelFlight(@PathVariable Long flightId) {
        flightService.cancel(flightId);
    }

    @DeleteMapping("/flights/{flightId}/tourists/{touristId}")
    public void cancelReservation(@PathVariable Long flightId, @PathVariable Long touristId) {
        reservationService.cancelReservation(flightId, touristId);
    }

}
