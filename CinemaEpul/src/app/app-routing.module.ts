import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListeFilmsComponent } from './liste-films/liste-films.component';
import { LoginInComponent } from './login-in/login-in.component';
import { AuthGuard } from "./shared/auth.guard";

const routes: Routes = [
  { path: '', redirectTo: '/log-in', pathMatch: 'full' },
  { path: 'log-in', component:  LoginInComponent},
  { path: 'films', component: ListeFilmsComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
