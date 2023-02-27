import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductDetail} from "../entiry/product-detail";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(search: string, kindOfBook: string, page: number): Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/public/product/list?search=" + search + "&kindOfBook=" + kindOfBook + "&page=" + page);
  }
  findById(id: number): Observable<ProductDetail> {
    return this.httpClient.get("http://localhost:8080/api/public/product/detail/" + id);
  }
}
