import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import validate = WebAssembly.validate;
import {TokenService} from "../../service/token.service";
import {CustomerService} from "../../customer/service/customer.service";
import {Customer} from "../../customer/entity/customer";
import {Orders} from "../entity/orders";
import {OrdersService} from "../service/orders.service";
import {CartList} from "../entity/cart-list";
import {OrderDetail} from "../entity/order-detail";

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {
  cartList: CartList[] = [];
  formCreate: FormGroup = this.fb.group({});
  idAccount: string | null | undefined;
  customer: Customer = {};
  order: Orders = {};
  orderDetailList: OrderDetail[] = [];
  email: string | null = "";
  orderDetail: OrderDetail = {};

  constructor(private fb: FormBuilder,
              private tokenService: TokenService,
              private customerService: CustomerService,
              private ordersService: OrdersService) {
    this.formCreate = this.fb.group({
      deliveryAddress: ['', [Validators.required]],
      deliveryPhone: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.idAccount = this.tokenService.getId();
      this.email = this.tokenService.getEmail();
    }
    this.findCustomerByIdAccount(this.idAccount)
    this.getList();
  }

  creareOder() {
    this.order = this.formCreate.value;
    this.order.customer = this.customer;
    if (this.cartList.length > 0) {
      this.cartList.forEach(value => {
        this.orderDetail.idProduct = value.idProduct;
        this.orderDetail.amount = value.numberOfProduct;
        this.order.orderDetailSet?.push(this.orderDetail);
      })
    }
    console.log(this.order);
  }

  findCustomerByIdAccount(id: string | null | undefined) {
    this.customerService.findCustomerByIdAccount(id).subscribe(data => {
      this.customer = data;
    }, error => {
    }, () => {
    });
  }

  getList() {
    this.ordersService.getListCart(this.email).subscribe(data => {
      this.cartList = data;
      if (data != null) {
      } else {
      }
    }, error => {
    }, () => {
    })
  }
}
