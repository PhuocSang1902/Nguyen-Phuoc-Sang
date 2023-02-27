import { Component, OnInit } from '@angular/core';
import {OrdersService} from "../service/orders.service";

@Component({
  selector: 'app-cart-for-guest',
  templateUrl: './cart-for-guest.component.html',
  styleUrls: ['./cart-for-guest.component.css']
})
export class CartForGuestComponent implements OnInit {

  constructor(private ordersService: OrdersService) { }

  ngOnInit(): void {
  }

  getCart(){

  }
}
