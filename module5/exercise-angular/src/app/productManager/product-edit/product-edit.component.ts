import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../product.service';
import {Product} from '../product';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup = new FormGroup({});
  product: Product | null = {};

  constructor(private formBuilder: FormBuilder, private productService: ProductService, private activatedRoute: ActivatedRoute, private route: Router) {
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if (id != null) {
        this.product = this.productService.findById(parseInt(id));
      }
    }, error => {

    }, () => {
    });
    if (this.product!= null){
      this.productForm = this.formBuilder.group({
        id: [this.product.id],
        name: [this.product.name],
        price: [this.product.price],
        description: [this.product.description]
      });
    }


  }

  ngOnInit(): void {
  }

  saveProduct() {
    let product: Product;
    product = this.productForm.value;
    this.productService.saveProduct(product);
    this.productForm.reset();
    this.route.navigateByUrl("/product/list");
    alert("Cập nhập thành công");
  }
}
