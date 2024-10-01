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

  ngOnInit() {
    sessionStorage.removeItem('access_token');
    if (this.router.url === '/logout') {
      this.router.navigate(['login']);
    }
  }

  onSubmit() {
    this.auth.login(this.email, this.password).subscribe(data => {
      if (data && data?.accessToken && data?.tokenType) {
        sessionStorage.setItem("access_token", data?.accessToken);
        sessionStorage.setItem("token_type", data?.tokenType);
        this.router.navigateByUrl('/homepage');
      }
    });
  }
}
