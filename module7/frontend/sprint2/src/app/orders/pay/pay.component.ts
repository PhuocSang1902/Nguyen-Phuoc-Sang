import {Component, Input, OnInit} from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';
import {OrdersService} from "../service/orders.service";
import {ToastrService} from "ngx-toastr";
import {timeout} from "rxjs/operators";
import {Orders} from "../entity/orders";


@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {
  // @Input('order') order: Orders | undefined;

  constructor(private ordersService: OrdersService,
              private toast: ToastrService) {
    render(
      {
        id: '#payments',
        currency: 'USD',
        value: '100',
        onApprove: (details) => {
          // this.updatePaymentStatus(this.order?.id);
        }
      }
    );
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
}
