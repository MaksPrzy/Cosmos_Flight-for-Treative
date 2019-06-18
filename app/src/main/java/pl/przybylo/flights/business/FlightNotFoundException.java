package pl.przybylo.flights.business;

public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException(Long flightId) {
        super(String.format("Flight with ID %d not found.", flightId));
    }

}
