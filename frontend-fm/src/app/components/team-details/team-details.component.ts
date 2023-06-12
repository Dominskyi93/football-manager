import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {TeamsService} from '../../teams.service';
import {Team} from '../../team';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.scss']
})
export class TeamDetailsComponent implements OnInit {
  team: Team | undefined;
  editing = false;

  constructor(
    private route: ActivatedRoute,
    private teamsService: TeamsService,
    private location: Location,
  ) {
  }

  ngOnInit(): void {
    this.getTeamDetails();
  }

  getTeamDetails(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.teamsService.get(id).subscribe(team => {
      this.team = team;
    });
  }

  updateTeam(): void {
    if (this.team) {
      this.teamsService.update(this.team).subscribe(() => {
        this.editing = false;
      });
    }
  }

  goBack(): void {
    this.location.back();
  }

  editTeam() {
    this.editing = true;
  }

  cancelEdit() {
    this.editing = false;
  }
}
