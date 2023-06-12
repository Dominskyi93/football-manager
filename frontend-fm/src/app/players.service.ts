import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError, tap} from "rxjs/operators";
import {Player} from "./player";
import {PlayerRequestDto} from "./player-request-dto";

@Injectable({
  providedIn: 'root'
})
export class PlayersService {
  private playersUrl = 'http://localhost:8080/players';

  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  getPlayers(): Observable<Player[]> {
    return this.http.get<Player[]>(this.playersUrl)
      .pipe(
        tap(_ => this.log('fetched players')),
        catchError(this.handleError<Player[]>('getPlayers', []))
      );
  }

  get(id: number): Observable<Player> {
    const url = `${this.playersUrl}/${id}`;
    return this.http.get<Player>(url).pipe(
      tap(_ => this.log(`fetched player id=${id}`)),
      catchError(this.handleError<Player>(`getPlayer id=${id}`))
    );
  }

  add(playerRequestDto: PlayerRequestDto): Observable<any> {
    return this.http.post(this.playersUrl, playerRequestDto, this.httpOptions)
      .pipe(
        catchError(this.handleError<any>('addPlayer'))
      );
  }

  delete(id: number): Observable<any> {
    const url = `${this.playersUrl}/${id}`;
    return this.http.delete(url, this.httpOptions)
      .pipe(
        tap(_ => this.log(`Deleted player with ID ${id}`)),
        catchError(this.handleError<any>('deletePlayer'))
      );
  }

  update(player: Player): Observable<any> {
    const url = `${this.playersUrl}/${player.id}`;
    return this.http.put(url, player, this.httpOptions).pipe(
      tap(_ => this.log(`updated player id=${player.id}`)),
      catchError(this.handleError<any>('updatePlayer'))
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
    console.log(`PlayersService: ${message}`);
  }
}
