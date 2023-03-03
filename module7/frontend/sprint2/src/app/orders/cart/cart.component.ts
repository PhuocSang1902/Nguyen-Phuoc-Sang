import {Component, OnInit} from '@angular/core';
import {OrdersService} from "../service/orders.service";
import {Cart} from "../entity/cart";
import {TokenService} from "../../service/token.service";
import {Title} from "@angular/platform-browser";
import {CartList} from "../entity/cart-list";
import {ToastrService} from "ngx-toastr";

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
  flagDisplay = false;

  constructor(private ordersService: OrdersService,
              private tokenService: TokenService,
              private title: Title,
              private toast: ToastrService) {
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
      if (data != null) {
        this.flagDisplay = true;
      }else {
        this.flagDisplay = false;
        this.mess = "Không có sản phẩm nào trong giỏ hàng.";
      }
    }, error => {
      this.mess = "Không có sản phẩm nào trong giỏ hàng.";
    }, () => {
    })
  }

  deleteCart(id: number | undefined) {
    if (id != undefined) {
      this.ordersService.deleteCart(id).subscribe(data => {
        if (data != null) {
          this.toast.info("Xoá thành công.", "Thông báo", {timeOut: 500});
          this.getList();
        }else {
          this.toast.error("Xoá không thành công.", "Thông báo", {timeOut: 500});
        }
      }, error => {
        this.toast.error("Xoá không thành công.", "Thông báo", {timeOut: 500});
      }, () => {
      })
    }
  }
}
