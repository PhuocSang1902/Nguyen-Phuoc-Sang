import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrdersRoutingModule } from './orders-routing.module';
import { ListComponent } from './list/list.component';
import { CartComponent } from './cart/cart.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import {ReactiveFormsModule} from "@angular/forms";
import { PayComponent } from './pay/pay.component';


@NgModule({
  declarations: [ListComponent, CartComponent, CreateOrderComponent, PayComponent],
  imports: [
    CommonModule,
    OrdersRoutingModule,
    ReactiveFormsModule
  ],
  exports: [
  ]
})
export class OrdersModule { }
