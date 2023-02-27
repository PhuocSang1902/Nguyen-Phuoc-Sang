import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private httpClient: HttpClient) {
  }

  findCartForGuest() {
    return this.httpClient.get("http://localhost:8080/api/public/cart-for-guest");
  }
}
