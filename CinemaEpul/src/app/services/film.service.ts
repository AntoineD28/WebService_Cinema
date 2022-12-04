import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Film } from '../liste-films/film';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  endpoint: string = 'http://localhost:8080/';
  headers: any;
  constructor(private httpClient: HttpClient) { 
    this.headers = new HttpHeaders()
    .append('Content-Type', 'application/json')
    .append('Access-Control-Allow-Headers', 'Content-Type')
    .append('Access-Control-Allow-Origin', '*');
  }

  getAllFilms(): Observable<Film[]> {
      return this.httpClient.get<any>(`${this.endpoint}films/all`, {headers: this.headers});
  }
}
