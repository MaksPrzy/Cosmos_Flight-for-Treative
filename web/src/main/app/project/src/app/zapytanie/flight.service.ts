import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FlightViewDto} from "./model/flight-view.dto";
import {Injectable} from "@angular/core";
import {FlightNewDto} from "./model/flight-new.dto";

@Injectable()
export class FlightService {

    constructor(private httpClient: HttpClient) {
    }

    public getFlights(): Observable<Array<FlightViewDto>> {
        return <Observable<Array<FlightViewDto>>>this.httpClient.get('/flights');
    }

    public addFlight(flightNewDto: FlightNewDto): Observable<FlightViewDto> {
        return <Observable<FlightViewDto>>this.httpClient.post('/flights', flightNewDto);
    }

}
