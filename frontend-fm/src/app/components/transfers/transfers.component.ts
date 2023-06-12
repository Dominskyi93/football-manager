import {Component, OnInit} from '@angular/core';
import {Team} from "../../team";
import {TeamsService} from "../../teams.service";
import {Player} from "../../player";
import {PlayersService} from "../../players.service";
import {TransferService} from "../../transfer.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-transfers',
  templateUrl: './transfers.component.html',
  styleUrls: ['./transfers.component.scss']
})
export class TransfersComponent implements OnInit {
  teams: Team[] = [];
  players: Player[] = [];
  selectedSellingPlayer: number = 0;
  selectedBuyingTeam: number = 0;
  transferMessage: string = '';

  constructor(
    private teamsService: TeamsService,
    private playersService: PlayersService,
    private transferService: TransferService,
    private location: Location) {
  }

  ngOnInit() {
    this.getTeams();
    this.getPlayers();
  }

  getTeams(): void {
    this.teamsService.getTeams()
      .subscribe(teams => this.teams = teams);
  }

  getPlayers(): void {
    this.playersService.getPlayers()
      .subscribe(players => this.players = players);
  }

  transferPlayer(): void {
    this.transferService.transfer(this.selectedSellingPlayer, this.selectedBuyingTeam).subscribe(
      response => {
        this.transferMessage = response;
      }
    );
  }

  goBack(): void {
    this.location.back();
  }
}
