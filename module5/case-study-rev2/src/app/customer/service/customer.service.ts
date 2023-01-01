import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  urlCustomer = 'http://localhost:3000/customer';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.urlCustomer);
  }

  create(customer: Customer): Observable<Customer> {
    return this.httpClient.post(this.urlCustomer, customer);
  }

  update(customer: Customer): Observable<Customer> {
    return this.httpClient.patch(this.urlCustomer + '/' + customer.id, customer);
  }

  getById(id: number): Observable<Customer> {
    return this.httpClient.get(this.urlCustomer + '/' + id);
  }

  deleteById(customer: Customer):Observable<Customer> {
    return this.httpClient.delete(this.urlCustomer + '/' + customer.id)
  }
}
