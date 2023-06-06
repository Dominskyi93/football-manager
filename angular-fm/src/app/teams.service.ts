import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TeamsService {
  private teams: Team[] = [];

  constructor(private http: HttpClient) {
    this.http.get<Team[]>('api/teams').subscribe(data => {
      this.teams = data;
    });
  }

  getTeams(): Team[] {
    return this.teams;
  }

  addTeam(team: Team): void {
    this.teams.push(team);
  }

  deleteTeam(team: Team): void {
    const index = this.teams.indexOf(team);
    if (index !== -1) {
      this.teams.splice(index, 1);
    }
  }
}

