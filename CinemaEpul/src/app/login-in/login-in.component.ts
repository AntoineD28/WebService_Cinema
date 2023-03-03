import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from './../shared/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-in',
  templateUrl: './login-in.component.html',
  styleUrls: ['./login-in.component.scss']
})
export class LoginInComponent {
  signinForm: FormGroup;
  constructor(
    public fb: FormBuilder,
    public authService: AuthService,
    public router: Router
  ) {
    this.signinForm = this.fb.group({
      nomUtil: [''],
      motPasse: [''],
    });
  }
  ngOnInit() {}
  loginUser() {
    this.authService.signIn(this.signinForm.value).subscribe(() => {
      localStorage.setItem('nomUtil', this.signinForm.get('nomUtil')?.value);
      this.router.navigate(['films']/*, {state: {data: this.signinForm.get('nomUtil')?.value}}*/);
    });
  }
}
