import { Component } from '@angular/core';
import { Categorie } from './categorie';
import { CategorieService } from '../services/categorie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.scss']
})
export class CategorieComponent {
  categories: Categorie[] = [];

  constructor (private service: CategorieService, private router: Router) {}

  ngOnInit(): void {
    this.service.getAllCategories()
    .subscribe((response) => {
        this.categories = response;
        console.log(response);
      })
  }

  navToFilm(id : String) {
    this.router.navigate(['/film'], { queryParams: { id } });
  }

}
