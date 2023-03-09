import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) {
  }

  findCustomerById(id: string | null | undefined): Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/user/customer/find-by-id?id=" + id)
  }
}
