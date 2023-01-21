import { Component, OnInit } from '@angular/core';
import { Acteur } from './acteur';
import { FilmService } from '../services/film.service';

@Component({
  selector: 'app-liste-acteurs',
  templateUrl: './liste-acteurs.component.html',
  styleUrls: ['./liste-acteurs.component.scss']
})
export class ListeActeursComponent implements OnInit {

  Acteurs : Acteur[] = [];

  constructor(private service: FilmService) { }

  ngOnInit() {
    this.service.getAllActeurs()
      .subscribe(data => {
        this.Acteurs = data;
        console.log(this.Acteurs);
      });
  }

}
