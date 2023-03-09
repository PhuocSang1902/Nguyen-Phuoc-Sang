import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListComponent} from "../product/list/list.component";
import {CartComponent} from "./cart/cart.component";
import {CreateOrderComponent} from "./create-order/create-order.component";
import {ComfirmOrderComponent} from "./comfirm-order/comfirm-order.component";
import {PayComponent} from "./pay/pay.component";

const routes: Routes = [
  {
    path: 'cart', component: CartComponent
  }, {
    path: 'create', component: CreateOrderComponent
  },
  {
    path: 'confirm', component: ComfirmOrderComponent
  },
  {
    path: 'pay', component: PayComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrdersRoutingModule {
}
