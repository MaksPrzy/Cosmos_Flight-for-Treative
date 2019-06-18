import {PlaceWithDateDto} from "./place-with-date.dto";

export interface FlightNewDto {
    name: string;
    departure: PlaceWithDateDto;
    arrival: PlaceWithDateDto;
    sitCount: number;
    ticketPrice: number;
}
