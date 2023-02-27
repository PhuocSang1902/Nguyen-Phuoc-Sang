import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from "../product/list/list.component";
import {CartComponent} from "./cart/cart.component";
import {CartForGuestComponent} from "./cart-for-guest/cart-for-guest.component";

const routes: Routes = [
  {
    path: 'cart', component: CartComponent
  },
  {
    path: 'cart-for-guest', component: CartForGuestComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrdersRoutingModule { }
