import { Component } from '@angular/core';
import { Categorie } from './categorie';
import { CategorieService } from '../services/categorie.service';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.scss']
})
export class CategorieComponent {
  categories: Categorie[] = [];

  constructor (private service: CategorieService) {}

  ngOnInit(): void {
    this.service.getAllCategories()
    .subscribe((response) => {
        this.categories = response;
        console.log(response);
      })
  }

}
