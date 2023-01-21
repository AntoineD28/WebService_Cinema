import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorieComponent } from './categorie/categorie.component';
import { ListeActeursComponent } from './liste-acteurs/liste-acteurs.component';
import { ListeFilmsComponent } from './liste-films/liste-films.component';
import { LoginInComponent } from './login-in/login-in.component';
import { AuthGuard } from "./shared/auth.guard";

const routes: Routes = [
  { path: '', redirectTo: '/log-in', pathMatch: 'full' },
  { path: 'log-in', component:  LoginInComponent},
  { path: 'films', component: ListeFilmsComponent, canActivate: [AuthGuard]},
  { path: 'categories', component: CategorieComponent},
  { path: 'acteurs', component: ListeActeursComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
