import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListeFilmsComponent } from './liste-films/liste-films.component';
import { AuthInterceptor } from './shared/authconfig.interceptors';
import { LoginInComponent } from './login-in/login-in.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CategorieComponent } from './categorie/categorie.component';
import { ListeActeursComponent } from './liste-acteurs/liste-acteurs.component';

@NgModule({
  declarations: [
    AppComponent,
    ListeFilmsComponent,
    LoginInComponent,
    NavbarComponent,
    CategorieComponent,
    ListeActeursComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot([])
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
