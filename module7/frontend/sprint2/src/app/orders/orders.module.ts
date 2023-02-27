import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrdersRoutingModule } from './orders-routing.module';
import { ListComponent } from './list/list.component';
import { CartComponent } from './cart/cart.component';
import { CartForGuestComponent } from './cart-for-guest/cart-for-guest.component';


@NgModule({
  declarations: [ListComponent, CartComponent, CartForGuestComponent],
  imports: [
    CommonModule,
    OrdersRoutingModule
  ],
  exports: [
  ]
})
export class OrdersModule { }
