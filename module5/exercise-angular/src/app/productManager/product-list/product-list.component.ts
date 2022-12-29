import {Component, OnInit} from '@angular/core';
import {ProductService} from '../product.service';
import {Product} from '../product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

  deleteProduct(id: number | undefined) {
    if (id != undefined) {
      this.productService.deleteProduct(id);
    }
  }
}
