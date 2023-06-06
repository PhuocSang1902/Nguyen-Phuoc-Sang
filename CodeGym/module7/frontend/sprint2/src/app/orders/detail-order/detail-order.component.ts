import { Component, OnInit } from '@angular/core';
import {Orders} from "../entity/orders";
import {OrderDetailList} from "../entity/order-detail-list";
import {OrdersService} from "../service/orders.service";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail-order',
  templateUrl: './detail-order.component.html',
  styleUrls: ['./detail-order.component.css']
})
export class DetailOrderComponent implements OnInit {
  order: Orders = {};
  orderDetailList: OrderDetailList[] = [];
  flagDisplay = false;

  constructor(private ordersService: OrdersService,
              private toast: ToastrService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(result => {
      const id = result.get('id');
      if (id != null) {
        this.getOrderById(parseInt(id));
        this.getOrderDetailList(parseInt(id));
      }
    }, error => {
    }, () => {
    });
  }

  ngOnInit(): void {
  }

  getOrderById(id: number) {
    this.ordersService.findOrderById(id).subscribe(data => {
      this.order = data;
      console.log(this.order)
    }, error => {
    }, () => {
    });
  }

  getOrderDetailList(id: number) {
    this.ordersService.getOrderDetailList(id).subscribe(data => {
      this.orderDetailList = data;
      this.flagDisplay = true;
    }, error => {
      this.flagDisplay = false;
    }, () => {
    });
  }
}
