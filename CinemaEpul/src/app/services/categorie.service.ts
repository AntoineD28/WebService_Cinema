import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categorie } from '../categorie/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {
  endpoint: string = 'http://localhost:8080/';
  headers: any;
  constructor(private httpClient: HttpClient) { 
    this.headers = new HttpHeaders()
    .append('Content-Type', 'application/json')
    .append('Access-Control-Allow-Headers', 'Content-Type')
    .append('Access-Control-Allow-Origin', '*');
  }

  getAllCategories(): Observable<Categorie[]> {
      return this.httpClient.get<any>(`${this.endpoint}categories/all`, {headers: this.headers});
  }
}
