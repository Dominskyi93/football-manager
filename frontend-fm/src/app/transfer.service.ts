import {Injectable} from '@angular/core';
import {catchError, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TransferService {
  private transferUrl = 'http://localhost:8080/transfer';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) {
  }

  transfer(playerId: number, teamId: number) {
    const url = `${this.transferUrl}?playerId=${playerId}&teamId=${teamId}`;
    return this.http.post(url, {}, {responseType: 'text'}).pipe(
      tap(_ => this.log(`transferred player id=${playerId} to team id=${teamId}`)),
      catchError(this.handleError<any>(`transferPlayer`))
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
