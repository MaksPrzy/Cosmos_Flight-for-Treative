import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";
import {FlightsComponent} from "./zapytanie/component/flights/flights.component";

const routes: Routes = [
    {
        path: 'flights',
        component: FlightsComponent
    },
    {
        path: '**',
        component: PageNotFoundComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
      onSameUrlNavigation: 'ignore',
      enableTracing: false
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
