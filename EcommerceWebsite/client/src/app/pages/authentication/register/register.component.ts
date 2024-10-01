import { Component } from '@angular/core';
import { AuthService } from '../../../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  username: string = "";
  email: string = "";
  password: string = "";

  constructor(private auth: AuthService, private router: Router) {}

  onSubmit() {
    this.auth.register(this.email, this.password, this.username).subscribe(data => {
      this.router.navigateByUrl('/auth/login');
      alert("Register successed");
    });
  }
}
