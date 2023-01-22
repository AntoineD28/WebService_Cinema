import { Component, OnInit} from '@angular/core';
import { FilmService } from '../services/film.service';
import { Film } from './film';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Route, Router } from '@angular/router';

@Component({
  selector: 'app-liste-films',
  templateUrl: './liste-films.component.html',
  styleUrls: ['./liste-films.component.scss']
})
export class ListeFilmsComponent implements OnInit{

  films: Film[] = [];
  film: Film = {personnages: {}} as Film;
  showDetail = false;
  isModify = false;
  user: any;
  codeCat: any;
  
  constructor(private service:FilmService, private route: ActivatedRoute) {   }

  ngOnInit(): void {
    this.route.queryParams
    .subscribe(params => {
      console.log(params); // { orderby: "price" }
      this.codeCat = params['code'];
      console.log(this.codeCat); // price
      }
    );
    if (this.codeCat == undefined) 
    { 
      this.getFilms();
    }
    else
    {
      this.getFilmsCat(this.codeCat);
    }
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

  showDetails(id: any) {
    this.film = this.films[id];
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
