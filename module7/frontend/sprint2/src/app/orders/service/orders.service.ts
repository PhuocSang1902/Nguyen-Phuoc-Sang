import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Cart} from "../entity/cart";
import {BehaviorSubject, Observable} from "rxjs";
import {CartTotal} from "../entity/cart-total";
import {TokenService} from "../../service/token.service";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  totalCartBehaviorSubject: BehaviorSubject<any>;
  totalCostBehaviorSubject: BehaviorSubject<any>;
  totalProduct: number | undefined = 0;
  totalCost: number | undefined = 0;
  cartTotal: CartTotal = {};
  email: string | null | undefined;

  constructor(private httpClient: HttpClient,
              private tokenService: TokenService) {
    this.totalCartBehaviorSubject = new BehaviorSubject<any>(this.totalProduct);
    this.totalCostBehaviorSubject = new BehaviorSubject<any>(this.totalCost);
    if (this.tokenService.getToken()) {
      this.email = this.tokenService.getEmail();
    }
    this.getTotalCart(this.email);
  }

  addProductToCart(cart: Cart) {
    return this.httpClient.post("http://localhost:8080/api/user/cart/add-product-to-cart", cart)
  }

  getList(email: string | null): Observable<Cart[]> {
    return this.httpClient.get<Cart[]>("http://localhost:8080/api/user/cart/list-cart?email=" + email);
  }

  deleteCart(id: number): Observable<Cart> {
    return this.httpClient.delete("http://localhost:8080/api/user/cart/delete/" + id)
  }

  getTotalCart(email: string | null | undefined) {
    this.httpClient.get("http://localhost:8080/api/user/cart/get-total?email=" + email).subscribe(data => {
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
}
