import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  urlCustomer = 'http://localhost:3000/customers';

  constructor(private httpClient: HttpClient) {
  }

  getAll(page: number): Observable<any> {
    // return this.httpClient.get(this.urlCustomer);
    return this.httpClient.get('http://localhost:8080/customers?page=' + page);
  }

  getAllBySearch(page: number, search: string): Observable<any> {
    // return this.httpClient.get(this.urlCustomer);
    return this.httpClient.get('http://localhost:8080/customers/search/' + search + '?page=' + page);
  }

  create(customer: Customer): Observable<Customer> {
    // return this.httpClient.post(this.urlCustomer, customer);
    return this.httpClient.post('http://localhost:8080/customers', customer);
  }

  update(customer: Customer): Observable<Customer> {
    return this.httpClient.patch('http://localhost:8080/customers/' + customer.id, customer);
  }

  getById(id: number): Observable<Customer> {
    return this.httpClient.get('http://localhost:8080/customers/' + id);
  }

  deleteById(customer: Customer): Observable<Customer> {
    return this.httpClient.delete('http://localhost:8080/customers/' + customer.id);
  }

  getAllUseFacility(page: number): Observable<any> {
    return this.httpClient.get('http://localhost:8080/customers/use-facility?page=' + page);
  }

  getAllUseFacilityBySearch(page: number, search: string): Observable<any> {
    // return this.httpClient.get(this.urlCustomer + '/name_like=' + search);
    return this.httpClient.get('http://localhost:8080/customers/use-facility/search/' + search + '?page=' + page);
  }

  getListCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>('http://localhost:8080/customers/select-list');
  }
}
