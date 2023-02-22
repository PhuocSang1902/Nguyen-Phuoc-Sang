import {Component, OnInit} from '@angular/core';
import {ProductService} from "../service/product.service";
import {ProductHome} from "../entiry/productHome";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  page: number = 0;
  totalPage: number = 0;
  productList: ProductHome[] = [];
  search:string = "";

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.findAll(this.search, this.page)
  }

  findAll(search: string, page: number) {
    this.productService.findAll(search, page).subscribe(data => {
      this.productList = data.content;
      this.page = data.number;
      this.totalPage = data.totalPages;
    }, error => {
    }, () => {
    })
  }


}
