import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {ProductDetail} from "../entiry/product-detail";
import {ProductHome} from "../entiry/productHome";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productBehaviorSubject: BehaviorSubject<any>;
  productPage: any;
  search = "";
  kindOfBook = "";
  page = 0;

  constructor(private httpClient: HttpClient) {
    this.productBehaviorSubject = new BehaviorSubject<any>(this.productPage)
    this.getListForHomePage(this.search, this.kindOfBook, this.page)
  }

  findAll(search: string, kindOfBook: string, page: number): Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/public/product/list?search=" + search + "&kindOfBook=" + kindOfBook + "&page=" + page);
  }

  findById(id: number): Observable<ProductDetail> {
    return this.httpClient.get("http://localhost:8080/api/public/product/detail/" + id);
  }

  getListForHomePage(search: string, kindOfBook: string, page: number) {
    this.findAll(search, kindOfBook, page).subscribe(data => {
      this.productPage = data
      this.search = search;
      this.kindOfBook = kindOfBook;
      this.page = data.number;
      this.productBehaviorSubject.next(this.productPage)
    }, error => {
    }, () => {
    })
  }
  showHomePageWithPage(page: number){
    this.getListForHomePage(this.search, this.kindOfBook, page)
  }
}
