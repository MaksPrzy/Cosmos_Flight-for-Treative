package pl.przybylo.flights.business;

public class TouristNotFoundException extends RuntimeException {

    public TouristNotFoundException(Long touristId) {
        super(String.format("Tourist with ID %d not found.", touristId));
    }

}
