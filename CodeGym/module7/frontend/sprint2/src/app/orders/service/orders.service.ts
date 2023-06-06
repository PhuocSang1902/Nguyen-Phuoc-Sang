import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Cart} from "../entity/cart";
import {BehaviorSubject, Observable} from "rxjs";
import {CartTotal} from "../entity/cart-total";
import {TokenService} from "../../service/token.service";
import {Orders} from "../entity/orders";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  totalCartBehaviorSubject: BehaviorSubject<any>;
  totalCostBehaviorSubject: BehaviorSubject<any>;
  totalProduct: number | undefined = 0;
  totalCost: number | undefined = 0;
  cartTotal: CartTotal = {};
  idCustomer: string | null | undefined;

  constructor(private httpClient: HttpClient,
              private tokenService: TokenService) {
    this.totalCartBehaviorSubject = new BehaviorSubject<any>(this.totalProduct);
    this.totalCostBehaviorSubject = new BehaviorSubject<any>(this.totalCost);
    if (this.tokenService.getToken()) {
      this.idCustomer = this.tokenService.getIdCustomer();
    }
    this.getTotalCart(this.idCustomer);
  }

  addProductToCart(cart: Cart) {
    return this.httpClient.post("http://localhost:8080/api/user/cart/add-product-to-cart", cart)
  }

  getListCart(idCustomer: string | null | undefined): Observable<Cart[]> {
    return this.httpClient.get<Cart[]>("http://localhost:8080/api/user/cart/list-cart?idCustomer=" + idCustomer);
  }

  deleteCart(id: number): Observable<Cart> {
    return this.httpClient.delete("http://localhost:8080/api/user/cart/delete/" + id)
  }

  getTotalCart(idCustomer: string | null | undefined) {
    this.httpClient.get("http://localhost:8080/api/user/cart/get-total?idCustomer=" + idCustomer).subscribe(data => {
      if (data != null) {
        this.cartTotal = data;
        this.totalProduct = this.cartTotal.totalProduct;
        this.totalCost = this.cartTotal.totalCost
      } else {
        this.totalProduct = 0;
        this.totalCost = 0;
      }
      this.totalCartBehaviorSubject.next(this.totalProduct);
      this.totalCostBehaviorSubject.next(this.totalCost);
    }, error => {
      this.totalProduct = 0;
      this.totalCost = 0;
      this.totalCartBehaviorSubject.next(this.totalProduct);
      this.totalCostBehaviorSubject.next(this.totalCost);
    }, () => {
    })
  }

  updateNumberOfProduct(cart: Cart) {
    return this.httpClient.patch("http://localhost:8080/api/user/cart/update-amount-product", cart);
  }

  createOrder(order: Orders) {
    return this.httpClient.post("http://localhost:8080/api/user/order/create", order);
  }

  updatePaymentStatus(id: number | undefined) {
    return this.httpClient.patch("http://localhost:8080/api/user/order/pay-onl", id);
  }

  findOrderById(id: number): Observable<Orders> {
    return this.httpClient.get("http://localhost:8080/api/user/order/by-id/" + id);
  }

  getOrderDetailList(id: number): Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/user/order/detail-list/" + id);
  }

  getOrderList(id: number): Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/user/order/list/" + id);
  }

  findOrderByIdNotPay(id: number): Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/user/order/" + id);
  }
}
