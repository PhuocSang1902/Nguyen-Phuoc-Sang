import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {OrdersService} from "../service/orders.service";
import {Cart} from "../entity/cart";
import {TokenService} from "../../service/token.service";
import {Title} from "@angular/platform-browser";
import {CartList} from "../entity/cart-list";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class CartComponent implements OnInit {
  cartList: CartList[] = [];
  checkLogin = false;
  idCustomer: string | null | undefined;
  mess = "";
  flagDisplay = false;
  totalCost = 0;

  constructor(private ordersService: OrdersService,
              private tokenService: TokenService,
              private title: Title,
              private toast: ToastrService) {
    this.title.setTitle('Trang chủ');
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.idCustomer = this.tokenService.getIdCustomer();
    }
    this.getList();
    this.getCostTotal();
  }

  getList() {
    this.ordersService.getListCart(this.idCustomer).subscribe(data => {
      this.cartList = data;
      if (data != null) {
        this.flagDisplay = true;
      } else {
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
          this.ordersService.getTotalCart(this.idCustomer);
          this.getList();
        } else {
          this.toast.error("Xoá không thành công.", "Thông báo", {timeOut: 500});
        }
      }, error => {
        this.toast.error("Xoá không thành công.", "Thông báo", {timeOut: 500});
      }, () => {
      })
    }
  }

  updateNumberOfProduct(cart: Cart) {
    if (cart != null) {
      this.ordersService.updateNumberOfProduct(cart).subscribe(data => {
        this.ordersService.getTotalCart(this.idCustomer);
        this.getList();
        this.getCostTotal();
        if (data == null) {
          this.toast.error("Số lượng không được nhỏ hơn 1 và lớn hơn 100", "Thông báo", {timeOut: 500});
        }
      }, error => {
        if (error.status == 404) {
          this.toast.error("Số lượng không được nhỏ hơn 1 và lớn hơn 100", "Thông báo", {timeOut: 500});
        }
      }, () => {
      })
    } else {
      this.toast.info("Số lượng không được nhỏ hơn 1 và lớn hơn 100", "Thông báo", {timeOut: 500});
    }
  }

  addNumberOfProduct(cart: Cart) {
    if (cart.numberOfProduct != undefined && cart.id != undefined && cart.numberOfProduct < 100) {
      cart.numberOfProduct = cart.numberOfProduct + 1;
      this.updateNumberOfProduct(cart);
    }
  }

  subNumberOfProduct(cart: Cart) {
    if (cart.numberOfProduct != undefined && cart.id != undefined && cart.numberOfProduct > 1) {
      cart.numberOfProduct = cart.numberOfProduct - 1;
      this.updateNumberOfProduct(cart);
    }
  }

  getCostTotal() {
    this.ordersService.totalCostBehaviorSubject.subscribe(data => {
      if (data != null) {
        this.totalCost = data;
      } else {
        this.totalCost = 0;
      }
    }, error => {
      this.totalCost = 0;
    }, () => {
    })
  }
}
