import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TokenService} from "../../service/token.service";
import {CustomerService} from "../../customer/service/customer.service";
import {Customer} from "../../customer/entity/customer";
import {Orders} from "../entity/orders";
import {OrdersService} from "../service/orders.service";
import {OrderDetail} from "../entity/order-detail";
import {Router} from "@angular/router";
import {render} from "creditcardpayments/creditCardPayments";

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CreateOrderComponent implements OnInit {
  formCreate: FormGroup = this.fb.group({});
  idCustomer: string | null | undefined;
  customer: Customer = {};
  order: Orders = {};
  orderDetailList: OrderDetail[] = [];
  email: string | null = "";
  totalCost = 0;
  regexPhoneNumber: RegExp = /(09)\d{8}|(\+849)\d{8}/;
  flagDisplay = false;
  temp: Orders = {};
  id = '';

  constructor(private fb: FormBuilder,
              private tokenService: TokenService,
              private customerService: CustomerService,
              private ordersService: OrdersService,
              private route: Router,
              private cd: ChangeDetectorRef) {
    this.formCreate = this.fb.group({
      deliveryAddress: ['', [Validators.required]],
      deliveryPhone: ['', [Validators.required, Validators.pattern(this.regexPhoneNumber)]]
    });
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.idCustomer = this.tokenService.getIdCustomer();
      this.email = this.tokenService.getEmail();
    }
    this.getList();
    this.getCustomerById();
    this.getCostTotal();
  }

  getList() {
    this.ordersService.getListCart(this.idCustomer).subscribe(data => {
      this.orderDetailList = data;
      if (data != null) {
      } else {
      }
    }, error => {
    }, () => {
    })
  }

  getCustomerById() {
    this.customerService.findCustomerById(this.idCustomer).subscribe(data => {
      this.customer = data;
    }, error => {
    }, () => {
    });
  }

  getCostTotal() {
    this.ordersService.totalCostBehaviorSubject.subscribe(data => {
      this.totalCost = data;
      if (this.totalCost > 0) {
        this.flagDisplay = true;
      }
      this.cd.markForCheck();
    }, error => {
      this.totalCost = 0;
      this.flagDisplay = false;
    }, () => {
    })
  }

  setOrder() {
    this.order = this.formCreate.value;
    this.order.customer = this.customer;
    this.order.orderDetailSet = this.orderDetailList;
    this.order.orderValue = this.totalCost;
    console.log(this.order)
  }

  createOderWithPay() {
    this.setOrder();
    this.ordersService.createOrder(this.order).subscribe(data => {
      this.ordersService.getTotalCart(this.idCustomer);
      this.temp = data;
      this.id = '' + this.temp.id;
      this.route.navigate(['/order/pay', this.id]);
    }, error => {
      this.route.navigateByUrl("/order/cart");
    }, () => {
    })
  }

  createOder() {
    this.setOrder();
    this.ordersService.createOrder(this.order).subscribe(data => {
      this.ordersService.getTotalCart(this.idCustomer);
      this.temp = data;
      this.id = '' + this.temp.id;
      this.route.navigate(['/order/confirm', this.id]);
    }, error => {
      this.route.navigateByUrl("/order/cart");
    }, () => {
    })
  }
}
