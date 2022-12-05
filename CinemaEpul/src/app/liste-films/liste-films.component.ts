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
  user: any;
  
  constructor(private service:FilmService) { }

  ngOnInit(): void {
    this.getFilms();
    /*this.user = history.state.data;
    console.log(history.state.data);*/
  }

  getFilms() : void {
    this.service.getAllFilms()
      .subscribe((response) => {
        this.films = response;
        console.log(this.films);
      });
  }
  
}
