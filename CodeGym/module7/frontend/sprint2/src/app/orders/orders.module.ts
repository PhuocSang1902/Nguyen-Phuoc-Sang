import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrdersRoutingModule } from './orders-routing.module';
import { CartComponent } from './cart/cart.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import {ReactiveFormsModule} from "@angular/forms";
import { PayComponent } from './pay/pay.component';
import { ComfirmOrderComponent } from './comfirm-order/comfirm-order.component';
import { ListComponent } from './list/list.component';
import { DetailOrderComponent } from './detail-order/detail-order.component';
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [CartComponent, CreateOrderComponent, PayComponent, ComfirmOrderComponent, ListComponent, DetailOrderComponent],
  imports: [
    CommonModule,
    OrdersRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  exports: [
  ]
})
export class OrdersModule { }
