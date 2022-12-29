import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Product} from '../product';
import {ProductService} from '../product.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;

  constructor(private formBuilder: FormBuilder,private productService: ProductService) {
    this.productForm = this.formBuilder.group({
      id: [''],
      name: [''],
      price: [''],
      description: ['']
    });
  }

  ngOnInit(): void {
  }

  saveProduct() {
    let product:Product;
    product = this.productForm.value;
    this.productService.saveProduct(product);
    this.productForm.reset();
  }
}
