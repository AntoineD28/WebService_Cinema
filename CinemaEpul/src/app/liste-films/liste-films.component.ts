import { Component, OnInit} from '@angular/core';
import { FilmService } from '../services/film.service';
import { Film } from './film';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-liste-films',
  templateUrl: './liste-films.component.html',
  styleUrls: ['./liste-films.component.scss']
})
export class ListeFilmsComponent {

  films: Film[] = [];
  film: Film = {personnages: {}} as Film;
  showDetail = false;
  isModify = false;
  user: any;
  codeCate: string = "";
  
  constructor(private service:FilmService, private route: ActivatedRoute) {   }

  ngOnInit(): void {
    /*this.route.paramMap
          .subscribe(param => {
        this.codeCate = param.get('codeCate');
      })
    if (this.codeCate != undefined) 
    {
      console.log(this.codeCate)
      this.getFilmsCat(this.codeCate);
    }
    else
    {
      this.getFilms();
    }*/
    /*this.user = history.state.data;
    console.log(history.state.data);*/
    this.getFilms();
  }

  getFilms() : void {
    this.service.getAllFilms()
      .subscribe((response) => {
        this.films = response;
        console.log(this.films);
      });
  }

  getFilmsCat(id : string) : void {
    this.service.getFilmByCat(id)
      .subscribe((response) => {
        this.films = response;
        console.log(this.films);
      });
  }

  showDetails(id: number) {
    this.film = this.films[id-1];
    this.showDetail = true;
  }

  hideDetails() {
    this.showDetail = false;
  }

  modifyFilm() {
    this.isModify = true;
  }

  saveFilm(f: Film) {
    this.service.SupdateFilm(f);
    this.isModify = false;
  }
  
}
