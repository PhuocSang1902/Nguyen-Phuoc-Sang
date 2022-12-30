import {Injectable} from '@angular/core';
import {Product} from './product';
import {FormBuilder} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:3000/products');
  }

  saveProduct(product: Product) {
    return this.httpClient.post<Product>('http://localhost:3000/products', product);
  }

  findById(number: number): Observable<Product> {
    console.log(number);
    return this.httpClient.get('http://localhost:3000/products/' + number);
  }

  deleteProduct(id: number):Observable<Product> {
    return this.httpClient.delete('http://localhost:3000/products/'+ id)
  }

  updateProduct(product: Product) {
    return this.httpClient.patch('http://localhost:3000/products/'+ product.id, product);
  }
}
