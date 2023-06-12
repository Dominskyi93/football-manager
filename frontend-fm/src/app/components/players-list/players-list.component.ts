import {Component, OnInit} from '@angular/core';
import {Player} from "../../player";
import {PlayersService} from "../../players.service";

@Component({
  selector: 'app-players-list',
  templateUrl: './players-list.component.html',
  styleUrls: ['./players-list.component.scss']
})
export class PlayersListComponent implements OnInit {
  players: Player[] = [];
  firstName: string = '';
  lastName: string = '';
  dateOfBirth: Date = new Date();
  dateOfStartCareer: Date = new Date();
  nationality: string = '';

  constructor(private playersService: PlayersService) {
  }

  ngOnInit() {
    this.getPlayers();
  }

  delete(id: number): void {
    this.players = this.players.filter(player => player.id !== id);
    this.playersService.delete(id).subscribe();
  }

  getPlayers(): void {
    this.playersService.getPlayers()
      .subscribe(players => this.players = players);
  }

  confirmDelete(playerId: number) {
    if (confirm('Are you sure you want to delete this player?')) {
      this.delete(playerId);
    }
  }

  addPlayerClick() {
    const playerRequestDto = {
      firstName: this.firstName,
      lastName: this.lastName,
      dateOfBirth: this.dateOfBirth,
      dateOfStartCareer: this.dateOfStartCareer,
      nationality: this.nationality
    };
    this.playersService.add(playerRequestDto)
      .subscribe(player => {
        this.players.push(player);
      });
  }
}
