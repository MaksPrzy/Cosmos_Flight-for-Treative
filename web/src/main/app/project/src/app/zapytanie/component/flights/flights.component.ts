import {Component} from "@angular/core";
import {NotificationService} from "../../../service/notification/notification.service";
import {FlightService} from "../../flight.service";
import {FlightViewDto} from "../../model/flight-view.dto";
import {FlightNewDto} from "../../model/flight-new.dto";

@Component({
    selector: 'mp-flights',
    templateUrl: './flights.component.html',
    styleUrls: ['./flights.component.scss']
})
export class FlightsComponent {

    flights: Array<FlightViewDto>;

    constructor(private flightService: FlightService,
                private notificationService: NotificationService) {
        this.loadFlights();
    }

    private loadFlights(): void {
        this.flightService.getFlights().subscribe((flights: Array<FlightViewDto>) => {
            this.flights = flights;
            this.notificationService.showSuccess('Flights loaded', 'Cosmos Flights');
        });
    }

    public onAddFlight(): void {
        const flightNewDto: FlightNewDto = {
            name: 'Kraków >> Rzeszów',
            departure: {
                place: "Kraków",
                dateTime: new Date()
            },
            arrival: {
                place: "Rzeszów",
                dateTime: new Date()
            },
            sitCount: 200,
            ticketPrice: 199.99
        }
        this.flightService.addFlight(flightNewDto).subscribe((flightViewDto: FlightViewDto) => {
            this.notificationService.showSuccess('New flight added!.', 'Cosmos Flights');
            this.loadFlights();
        });
    }

}
