package pl.przybylo.flights.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@Entity
@Getter
@Setter
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "place", column = @Column(name = "departure_place")),
            @AttributeOverride(name = "dateTime", column = @Column(name = "departure_date"))
    })
    private PlaceWithDate departure;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "place", column = @Column(name = "arrival_place")),
            @AttributeOverride(name = "dateTime", column = @Column(name = "arrival_date"))
    })
    private PlaceWithDate arrival;

    private Integer sitCount;
    private Integer touristCount;
    private BigDecimal ticketPrice;
    private boolean removed;

    @ManyToMany
    @JoinTable(name = "tourist_flights",
            joinColumns = {@JoinColumn(name = "flight_id")},
            inverseJoinColumns = {@JoinColumn(name = "tourist_id")})
    private Set<Tourist> tourists = newHashSet();

    public Flight() {
        touristCount = 0;
        removed = false;
    }

    public Flight(String name, PlaceWithDate departure, PlaceWithDate arrival, Integer sitCount, BigDecimal ticketPrice) {
        this();
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.sitCount = sitCount;
        this.ticketPrice = ticketPrice;
    }

}
