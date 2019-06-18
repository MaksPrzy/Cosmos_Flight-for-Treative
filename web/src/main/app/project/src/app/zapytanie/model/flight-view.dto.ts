import {PlaceWithDateDto} from "./place-with-date.dto";
import {TouristViewDto} from "./tourist-view.dto";

export interface FlightViewDto {
    id: number;
    name: string;
    departure: PlaceWithDateDto;
    arrival: PlaceWithDateDto;
    sitCount: number;
    touristCount: number;
    ticketPrice: number;
    tourists: Array<TouristViewDto>;
}
