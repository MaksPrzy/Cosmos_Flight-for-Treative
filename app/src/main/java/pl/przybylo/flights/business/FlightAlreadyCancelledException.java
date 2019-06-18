package pl.przybylo.flights.business;

public class FlightAlreadyCancelledException extends RuntimeException {

    public FlightAlreadyCancelledException(Long flightId) {
        super(String.format("Sorry, flight with ID %d already cancelled or removed!", flightId));
    }

}
