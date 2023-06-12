import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TeamsListComponent} from "./components/teams-list/teams-list.component";
import {TeamDetailsComponent} from "./components/team-details/team-details.component";
import {PlayersListComponent} from "./components/players-list/players-list.component";
import {PlayerDetailsComponent} from "./components/player-details/player-details.component";
import {TeamsPlayersComponent} from "./components/teams-players/teams-players.component";
import {HomePageComponent} from "./components/home-page/home-page.component";
import {TransfersComponent} from "./components/transfers/transfers.component";

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'teams', component: TeamsListComponent},
  {path: 'teams/:id', component: TeamDetailsComponent},
  {path: 'players', component: PlayersListComponent},
  {path: 'players/:id', component: PlayerDetailsComponent},
  {path: 'teams/:id/players', component: TeamsPlayersComponent},
  {path: 'home', component: HomePageComponent},
  {path: 'transfer', component: TransfersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
