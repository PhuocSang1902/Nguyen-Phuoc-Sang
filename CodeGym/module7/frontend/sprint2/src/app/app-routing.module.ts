import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./common/login/login.component";
import {SignUpComponent} from "./common/sign-up/sign-up.component";

const routes: Routes = [
  {path: '', redirectTo: 'product', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'sign-up', component: SignUpComponent},
  {
    path: 'product', loadChildren: () => import('./product/product.module').then(module => module.ProductModule)
  },
  {
    path: 'order', loadChildren: () => import('./orders/orders.module').then(module => module.OrdersModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }