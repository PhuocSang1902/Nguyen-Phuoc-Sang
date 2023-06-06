import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CartComponent} from "./cart/cart.component";
import {CreateOrderComponent} from "./create-order/create-order.component";
import {ComfirmOrderComponent} from "./comfirm-order/comfirm-order.component";
import {PayComponent} from "./pay/pay.component";
import {ListComponent} from "./list/list.component";
import {DetailOrderComponent} from "./detail-order/detail-order.component";
import {UserGuard} from "../authGauth/user.guard";
import {AdminUserGuard} from "../authGauth/admin-user.guard";

const routes: Routes = [
  {
    path: 'cart', component: CartComponent, canActivate: [AdminUserGuard]
  }, {
    path: 'create', component: CreateOrderComponent, canActivate: [AdminUserGuard]
  },
  {
    path: 'confirm/:id', component: ComfirmOrderComponent, canActivate: [AdminUserGuard]
  },
  {
    path: 'pay/:id', component: PayComponent, canActivate: [AdminUserGuard]
  },
  {
    path: '', component: ListComponent, canActivate: [AdminUserGuard]
  },
  {
    path: 'order-detail/:id', component: DetailOrderComponent, canActivate: [AdminUserGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrdersRoutingModule {
}
