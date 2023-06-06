import {Component, Input, OnInit} from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';
import {OrdersService} from "../service/orders.service";
import {ToastrService} from "ngx-toastr";
import {timeout} from "rxjs/operators";
import {Orders} from "../entity/orders";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {
  order: Orders = {};
  cost: number | undefined = 0;
  flagDisplay = false
  constructor(private ordersService: OrdersService,
              private toast: ToastrService,
              private activatedRoute: ActivatedRoute,
              private route: Router) {
    this.activatedRoute.paramMap.subscribe(result => {
      const id = result.get('id');
      if (id != null) {
        this.getOrderById(parseInt(id));
      }
    }, error => {
    }, () => {
    });
  }

  ngOnInit(): void {
  }

  updatePaymentStatus(id: number | undefined) {
    this.ordersService.updatePaymentStatus(id).subscribe(data => {
      this.toast.info("Thanh toán thành công", "Thông báo", {timeOut: 500});
    }, error => {
      this.toast.error("Thanh toán không thành công", "Thông báo", {timeOut: 500});
    }, () => {
    })
  }

  getOrderById(id: number) {
    this.ordersService.findOrderByIdNotPay(id).subscribe(data => {
      this.order = data;
      // @ts-ignore
      this.cost = (this.order.orderValue/24000).toFixed(2);
      render(
        {
          id: "#payments",
          currency: "USD",
          value: '' + (this.cost),
          onApprove: (details) => {
            this.updatePaymentStatus(this.order?.id);
            this.route.navigate(['/order/confirm', this.order.id]);
          }
        }
      );
      this.flagDisplay = true;
    }, error => {
      this.flagDisplay = false
    }, () => {
    });
  }
}
