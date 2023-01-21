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
  noFilm: any;
  constructor(private httpClient: HttpClient) { 
    this.headers = new HttpHeaders()
    .append('Content-Type', 'application/json')
    .append('Access-Control-Allow-Headers', 'Content-Type')
    .append('Access-Control-Allow-Origin', '*');
  }

  getAllFilms(): Observable<Film[]> {
      return this.httpClient.get<any>(`${this.endpoint}films/all`, {headers: this.headers});
  }

  getFilmByCat(id : string) : Observable<Film[]> {
    return this.httpClient.get<any>(`${this.endpoint}films/byCategorie/${id}`, {headers: this.headers});
}

  SupdateFilm(f: Film) {
    console.log(f);
    this.httpClient.put(`${this.endpoint}films/update`, f, {headers: this.headers})
      .subscribe(data => this.noFilm = data);
  }

  getAllActeurs() {
    return this.httpClient.get<any>(`${this.endpoint}acteurs/all`, {headers: this.headers});
  }
}
