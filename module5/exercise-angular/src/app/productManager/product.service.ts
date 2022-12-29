import {Injectable} from '@angular/core';
import {Product} from './product';
import {FormBuilder} from '@angular/forms';

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

  constructor() {
  }

  getAll() {
    return this.products;
  }

  saveProduct(product: Product) {
    let productById = this.products.filter(item => item.id === product.id);
    if (productById.length === 0) {
      this.products.push(product);
    } else {
      for (let i = 0; i < this.products.length; i++) {
        if (this.products[i].id === product.id) {
          this.products[i] = product;
          break;
        }
      }
    }
  }

  findById(number: number): Product | null {
    let temp = this.products.filter(item => item.id === number);
    if (temp.length != 0) {
      return temp[0];
    }
    return null;
  }

  deleteProduct(id: number) {
    let temp = this.products.filter(item => item.id === id);
    if (temp.length != 0) {
      let length = this.products.length
      for (let i = 0; i < length; i++) {
        if (this.products[i].id === id) {
          this.products.splice(i, 1);
          break;
        }
      }
    }
  }
}
