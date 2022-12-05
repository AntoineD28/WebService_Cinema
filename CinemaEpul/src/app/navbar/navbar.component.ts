import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AnyTxtRecord } from 'dns';
import { AuthService } from '../shared/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  //@Input() userName: any;
  userName = localStorage.getItem('nomUtil');

  constructor (public authService: AuthService, public router: Router) { }
  

  LogOut() {
    this.authService.doLogout();
  }

  navCat() {
    this.router.navigate(['/categories']);
  }

}
