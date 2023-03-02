import {Component, OnInit} from '@angular/core';
import {ProductService} from "../service/product.service";
import {ProductDetail} from "../entiry/product-detail";
import {ActivatedRoute} from "@angular/router";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  productDetail: ProductDetail = {};
  id: number = 0;
  flagDisplay: boolean = false;
  url: string | undefined = "";
  numberOrder: number = 1;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private title: Title) {
    this.title.setTitle('Trang chi tiết')
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if (id != null) {
        this.id = Number(id)
        this.findById(this.id)
      }
    }, error => {
    }, () => {
    })
  }

  findById(id: number) {
    this.productService.findById(id).subscribe(data => {
      this.productDetail = data;
      if (this.productDetail.imageSet != undefined) {
        this.url = this.productDetail.imageSet[0].url;
      } else {
        this.url = "https://upload.wikimedia.org/wikipedia/commons/b/b6/Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg"
      }

      this.flagDisplay = true;
    }, error => {
      this.flagDisplay = false;
    }, () => {
    })
  }

  changeImage(url: string | undefined): void {
    this.url = url;
  }

  addAmountOrder() {
    if (this.numberOrder <= 100) {
      this.numberOrder = this.numberOrder + 1;
    } else {
      this.numberOrder = 100;
    }
  }

  subAmountOrder() {
    if (this.numberOrder > 0) {
      this.numberOrder = this.numberOrder - 1;
    } else {
      this.numberOrder = 0;
    }
  }

  addToCart() {
  }
}
