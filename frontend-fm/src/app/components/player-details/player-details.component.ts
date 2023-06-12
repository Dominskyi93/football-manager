import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {Player} from "../../player";
import {PlayersService} from "../../players.service";
import {Team} from "../../team";

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.scss']
})
export class PlayerDetailsComponent implements OnInit {
  player: Player | undefined;
  team: Team | undefined;
  editing = false;

  constructor(
    private route: ActivatedRoute,
    private playerService: PlayersService,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    this.getPlayerDetails();
  }

  getPlayerDetails(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.playerService.get(id).subscribe(player => {
      this.player = player;
    });
  }

  cancelEdit() {
    this.editing = false;
  }

  editPlayer() {
    this.editing = true;
  }

  goBack(): void {
    this.location.back();
  }

  updatePlayer(): void {
    if (this.player) {
      this.playerService.update(this.player).subscribe(() => {
        this.editing = false;
      });
    }
  }
}
