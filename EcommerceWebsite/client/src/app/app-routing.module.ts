import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/authentication/login/login.component';
import { FullComponent } from './layouts/full/full.component';
import { BlankComponent } from './layouts/blank/blank.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { protectRoute } from './protect.route';
import { RegisterComponent } from './pages/authentication/register/register.component';

const routes: Routes = [
  {
    path: '',
    component: FullComponent,
    children: [
      {
        path: '',
        redirectTo: '/homepage',
        pathMatch: 'full'
      },
      {
        path: 'homepage',
        component: HomepageComponent,
        title: 'Home'
      }
    ],
  },
  {
    path: 'auth',
    component: BlankComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent,
        title: 'Login'
      },
      {
        path: 'register',
        component: RegisterComponent,
        title: 'Sign up'
      }
    ]
  },
  {
    path: '**',
    redirectTo: '/auth/login'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
