import {Component, OnInit} from '@angular/core';
import {OrdersService} from "../service/orders.service";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute} from "@angular/router";
import {Orders} from "../entity/orders";
import {OrderDetail} from "../entity/order-detail";
import {OrderDetailList} from "../entity/order-detail-list";

@Component({
  selector: 'app-comfirm-order',
  templateUrl: './comfirm-order.component.html',
  styleUrls: ['./comfirm-order.component.css']
})
export class ComfirmOrderComponent implements OnInit {
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
