import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {TeamsListComponent} from './components/teams-list/teams-list.component';
import {TeamDetailsComponent} from './components/team-details/team-details.component';
import {TeamsService} from "./teams.service";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {PlayersListComponent} from './components/players-list/players-list.component';
import {PlayerDetailsComponent} from './components/player-details/player-details.component';
import {TeamsPlayersComponent} from './components/teams-players/teams-players.component';
import {FormsModule} from "@angular/forms";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HomePageComponent} from './components/home-page/home-page.component';
import {TransfersComponent} from './components/transfers/transfers.component';
import {TransferService} from "./transfer.service";

@NgModule({
  declarations: [
    AppComponent,
    TeamsListComponent,
    TeamDetailsComponent,
    PlayersListComponent,
    PlayerDetailsComponent,
    TeamsPlayersComponent,
    HomePageComponent,
    TransfersComponent
  ],
  imports: [
    RouterModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule
  ],
  providers: [TeamsService, TransferService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
