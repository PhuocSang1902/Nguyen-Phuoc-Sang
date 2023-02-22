import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(search: string, page: number):Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/public/product/list?search=" + search + "&page=" + page);
  }
}
