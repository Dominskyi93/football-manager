import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {MessageService} from "./message.service";
import {Team} from "./team";
import {Player} from "./player";
import {TeamRequestDto} from "./team-request-dto";

@Injectable({
  providedIn: 'root'
})
export class TeamsService {
  private teamsUrl = 'http://localhost:8080/teams';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) {
  }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  getTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(this.teamsUrl)
      .pipe(
        tap(_ => this.log('fetched teams')),
        catchError(this.handleError<Team[]>('getTeams', []))
      );
  }

  get(id: number): Observable<Team> {
    const url = `${this.teamsUrl}/${id}`;
    return this.http.get<Team>(url).pipe(
      tap(_ => this.log(`fetched team id=${id}`)),
      catchError(this.handleError<Team>(`getTeam id=${id}`))
    );
  }

  update(team: Team): Observable<any> {
    const url = `${this.teamsUrl}/${team.id}`;
    return this.http.put(url, team, this.httpOptions).pipe(
      tap(_ => this.log(`updated team id=${team.id}`)),
      catchError(this.handleError<any>('updateTeam'))
    );
  }

  add(teamRequestDto: TeamRequestDto): Observable<any> {
    return this.http.post(this.teamsUrl, teamRequestDto, this.httpOptions)
      .pipe(
        catchError(this.handleError<any>('addTeam'))
      );
  }


  delete(id: number): Observable<any> {
    const url = `${this.teamsUrl}/${id}`;
    return this.http.delete(url, this.httpOptions)
      .pipe(
        tap(_ => this.log(`Deleted team with ID ${id}`)),
        catchError(this.handleError<any>('deleteTeam'))
      );
  }

  getTeamsPlayers(id: number): Observable<Player[]> {
    const url = `${this.teamsUrl}/${id}/players`;
    return this.http.get<Player[]>(url)
      .pipe(
        tap(_ => this.log('fetched teams')),
        catchError(this.handleError<Player[]>('getTeams', []))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }
}
