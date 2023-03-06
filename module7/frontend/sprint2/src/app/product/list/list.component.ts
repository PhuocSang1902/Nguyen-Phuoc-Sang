import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from "../service/product.service";
import {ProductHome} from "../entiry/productHome";
import {Subscription} from "rxjs";
import {Title} from "@angular/platform-browser";
import {TokenService} from "../../service/token.service";
import {ToastrService} from "ngx-toastr";
import {OrdersService} from "../../orders/service/orders.service";
import {Cart} from "../../orders/entity/cart";
import {ProductDetail} from "../entiry/product-detail";
import {Customer} from "../../customer/entity/customer";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ListComponent implements OnInit {
  page: number = 0;
  totalPage: number = 0;
  productList: ProductHome[] = [];
  flag = false;
  flagDisplay = false;
  checkLogin = false;
  name: string | null | undefined;
  roles: string[] = [];
  idAccount: string | null | undefined;
  cart: Cart = {};
  email: string | null | undefined;

  constructor(private productService: ProductService,
              private cd: ChangeDetectorRef,
              private title: Title,
              private tokenService: TokenService,
              private ordersService: OrdersService,
              private toast: ToastrService) {
    this.title.setTitle('Trang chủ')
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.name = this.tokenService.getName();
      this.roles = this.tokenService.getRole();
      this.idAccount = this.tokenService.getId();
      this.email = this.tokenService.getEmail();
    }
    this.getList();
  }

  getList() {
    this.productService.productBehaviorSubject.subscribe(data => {
      if (!this.flag) {
        this.productList = data['content'];
      } else {
        this.productList = this.productList.concat(data.content);
      }
      this.flagDisplay = true;
      this.totalPage = data['totalPages'];
      this.page = data['number'];
      this.cd.markForCheck();
    }, error => {
      this.flagDisplay = false;
    }, () => {
    })
  }

  showMore() {
    if (this.page < this.totalPage - 1) {
      this.page = this.page + 1;
      this.flag = true;
      this.productService.showHomePageWithPage(this.page);
    }
  }

  showLess() {
    if (this.page == this.totalPage - 1) {
      this.page = 0;
      this.flag = false;
      this.productService.showHomePageWithPage(this.page);
    }
  }

  addProductToCart(product: ProductDetail) {
    this.cart.productHome = product;
    this.cart.numberOfProduct = 1;
    this.cart.idAccount = Number(this.idAccount);
    this.ordersService.addProductToCart(this.cart).subscribe(data => {
      this.ordersService.getTotalCart(this.email);
      this.toast.info("Bạn đã thêm " + this.cart.productHome?.name + " thành công.",'Thông báo',{timeOut:500});
    }, error => {
        this.toast.error("Thêm giỏ hàng không thành công",'Thông báo',{timeOut:500});
    }, () => {
    });
  }
}
