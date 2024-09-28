import { Component } from '@angular/core';
import { AuthService } from '../../../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = "";
  password: string = "";

  constructor(private auth: AuthService, private router: Router) {}

  onSubmit() {
    this.auth.login(this.email, this.password).subscribe(data => {
      const token = data.accessToken;
      localStorage.setItem('token', token);
      this.router.navigateByUrl('/homepage');
    });
  }
}
