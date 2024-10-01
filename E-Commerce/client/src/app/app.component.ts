import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public title = 'AngularMock';

  constructor(
    private router: Router
  ) { }

  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    if(!sessionStorage.getItem("access_token")) {
      this.router.navigate(['login'])
    } else {
      this.router.navigate(['user/list'])
    }
  }
}
