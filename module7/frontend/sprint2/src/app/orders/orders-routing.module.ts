import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListComponent} from "../product/list/list.component";
import {CartComponent} from "./cart/cart.component";
import {CreateOrderComponent} from "./create-order/create-order.component";

const routes: Routes = [
  {
    path: 'cart', component: CartComponent
  }, {
    path: 'create', component: CreateOrderComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrdersRoutingModule {
}
