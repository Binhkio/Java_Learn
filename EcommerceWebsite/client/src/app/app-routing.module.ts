import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/authentication/login/login.component';
import { FullComponent } from './layouts/full/full.component';
import { BlankComponent } from './layouts/blank/blank.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { protectRoute } from './protect.route';
import { RegisterComponent } from './pages/authentication/register/register.component';
import { ProductComponent } from './pages/product/product.component';
import { AuthorizeGuard } from './shared/auth/authorize.guard';
import { CartComponent } from './pages/cart/cart.component';

const routes: Routes = [
  {
    path: '',
    component: FullComponent,
    canActivate: [AuthorizeGuard],
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
      },
      {
        path: 'product/:id',
        component: ProductComponent,
        title: 'Product detail'
      },
      {
        path: 'cart',
        component: CartComponent,
        title: 'Cart'
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
    redirectTo: '/homepage'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
