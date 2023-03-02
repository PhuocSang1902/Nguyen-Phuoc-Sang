import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Cart} from "../entity/cart";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private httpClient: HttpClient) {
  }

  addProductToCart(cart: Cart) {
    return this.httpClient.post("http://localhost:8080/api/user/cart/add-product-to-cart", cart)
  }

  getList(email: string | null): Observable<Cart[]> {
    return this.httpClient.get<Cart[]>("http://localhost:8080/api/user/cart/list-cart?email=" + email);
  }
}
