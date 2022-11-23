import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListeFilmsComponent } from './liste-films/liste-films.component';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
