import { Component, OnInit} from '@angular/core';
import { FilmService } from '../services/film.service';
import { Film } from './film';

@Component({
  selector: 'app-liste-films',
  templateUrl: './liste-films.component.html',
  styleUrls: ['./liste-films.component.scss']
})
export class ListeFilmsComponent {

  films: Film[] = [];
  
  constructor(private service:FilmService) { }

  ngOnInit(): void {
    this.getFilms();
  }

  getFilms() : void {
    this.service.getAllFilms()
      .subscribe((response) => {
        this.films = response;
        console.log(this.films);
      });
  }
  
}
