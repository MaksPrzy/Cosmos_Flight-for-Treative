import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {MessageService} from "primeng/primeng";
import {AppRequestInterceptor} from "./interceptor/app-request.interceptor";
import {ContentComponent} from "./component/content/content.component";
import {UserInterfaceModule} from "./user-interface.module";
import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";
import {FlightsComponent} from "./zapytanie/component/flights/flights.component";
import {FlightService} from "./zapytanie/flight.service";

@NgModule({
    declarations: [
        AppComponent,
        ContentComponent,
        FlightsComponent,
        PageNotFoundComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,

        UserInterfaceModule
    ],
    providers: [
        MessageService,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AppRequestInterceptor,
            multi: true
        },
        FlightService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {

}
