import {Component, OnInit} from '@angular/core';
import {OrdersService} from "../service/orders.service";
import {Cart} from "../entity/cart";
import {TokenService} from "../../service/token.service";
import {Title} from "@angular/platform-browser";
import {CartList} from "../entity/cart-list";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartList: CartList[] = [];
  checkLogin = false;
  name: string | null | undefined;
  roles: string[] = [];
  idAccount: string | null | undefined;
  email: string | null = "";
  mess = "";
  constructor(private ordersService: OrdersService,
              private tokenService: TokenService,
              private title: Title) {
    this.title.setTitle('Trang chủ')
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.name = this.tokenService.getName();
      this.email = this.tokenService.getEmail();
      this.roles = this.tokenService.getRole();
      this.idAccount = this.tokenService.getId();
    }
    this.getList();
  }

  getList() {
    this.ordersService.getList(this.email).subscribe(data => {
      this.cartList = data;
    }, error => {
      this.mess = "Không có sản phẩm nào trong giỏ hàng."
    }, () => {
    })
  }

}
