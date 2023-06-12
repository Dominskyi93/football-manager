import {Component, OnInit} from '@angular/core';
import {Team} from "../../team";
import {TeamsService} from "../../teams.service";

@Component({
  selector: 'app-teams-list',
  templateUrl: './teams-list.component.html',
  styleUrls: ['./teams-list.component.scss']
})
export class TeamsListComponent implements OnInit {
  teams: Team[] = [];
  title: string = '';
  city: string = '';
  country: string = '';
  balance: number = 0;
  commission: number = 0;

  constructor(
    private teamsService: TeamsService
  ) {
  }

  ngOnInit() {
    this.getTeams();
  }

  getTeams(): void {
    this.teamsService.getTeams()
      .subscribe(teams => this.teams = teams);
  }

  addTeamClick() {
    const teamRequestDto = {
      title: this.title,
      city: this.city,
      country: this.country,
      balance: this.balance,
      commission: this.commission
    };

    this.teamsService.add(teamRequestDto)
      .subscribe(team => {
        this.teams.push(team);
      });
  }

  confirmDelete(teamId: number) {
    if (confirm('Are you sure you want to delete this team?')) {
      this.delete(teamId);
    }
  }

  delete(id: number): void {
    this.teams = this.teams.filter(team => team.id !== id);
    this.teamsService.delete(id).subscribe();
  }

  updateTeam(team: Team): void {
    this.teamsService.update(team)
      .subscribe(() => {
      });
  }

  get(id: number): void {
    this.teamsService.get(id)
      .subscribe(team => {
      });
  }
}
