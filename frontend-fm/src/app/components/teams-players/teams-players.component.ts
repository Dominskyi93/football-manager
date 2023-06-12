import {Component, OnInit} from '@angular/core';
import {Player} from "../../player";
import {TeamsService} from "../../teams.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-teams-players',
  templateUrl: './teams-players.component.html',
  styleUrls: ['./teams-players.component.scss']
})
export class TeamsPlayersComponent implements OnInit {
  players: Player[] = [];

  ngOnInit() {
    this.getTeamsPlayers();
  }

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private teamsService: TeamsService) {
  }

  getTeamsPlayers(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.teamsService.getTeamsPlayers(id)
      .subscribe(players => this.players = players);
  }

  goBack(): void {
    this.location.back();
  }
}
