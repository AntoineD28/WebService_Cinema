import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  endpoint: string = 'http://localhost:8080/';
  headers = new HttpHeaders()
  .append('Content-Type', 'application/json')
  .append('Access-Control-Allow-Headers', 'Content-Type')
  .append('Access-Control-Allow-Origin', '*')
  .append('Access-Control-Allow-Origin', 'Origin, X-Requested-With, Content-Type, Accept');
  currentUser = {};
  constructor(private http: HttpClient, public router: Router) {}
  // Sign-in
  signIn(user: User) {
    return this.http
      .post<any>(`${this.endpoint}authentification/login`, { headers: this.headers })
      .subscribe((res: any) => {
        localStorage.setItem('access_token', res.token);
        console.log(res.token);
      });
  }
  getToken() {
    return localStorage.getItem('access_token');
  }
  get isLoggedIn(): boolean {
    let authToken = localStorage.getItem('access_token');
    return authToken !== null ? true : false;
  }
  doLogout() {
    let removeToken = localStorage.removeItem('access_token');
    if (removeToken == null) {
      this.router.navigate(['films']);
    }
  }
  // User profile
  /*getUserProfile(id: any): Observable<any> {
    let api = `${this.endpoint}/user-profile/${id}`;
    return this.http.get(api, { headers: this.headers }).pipe(
      map((res) => {
        return res || {};
      }),
      catchError(this.handleError)
    );
  }*/
  // Error
  handleError(error: HttpErrorResponse) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      msg = error.error.message;
    } else {
      // server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(msg);
  }
}