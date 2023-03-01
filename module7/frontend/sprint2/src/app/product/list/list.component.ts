import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from "../service/product.service";
import {ProductHome} from "../entiry/productHome";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ListComponent implements OnInit {
  page: number = 0;
  totalPage: number = 0;
  productList: ProductHome[] = [];
  search: string = "";
  kindOfBook: string = "";
  flag = false;
  flagDisplay = false;

  constructor(private productService: ProductService,
              private cd: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.productService.productBehaviorSubject.subscribe(data => {
      if (!this.flag){
        this.productList = data.content;
      }else {
        this.productList = this.productList.concat(data.content);
      }
      this.flagDisplay = true;
      this.totalPage = data.totalPages;
      this.page = data.number;
      this.cd.markForCheck();
    }, error => {
    }, () => {
    })
  }

  showMore() {
    if (this.page < this.totalPage - 1) {
      this.page = this.page + 1;
      this.flag = true;
      this.productService.showHomePageWithPage(this.page);
    }
  }

  showLess() {
    if (this.page == this.totalPage - 1) {
      this.page = 0;
      this.flag = false;
      this.productService.showHomePageWithPage(this.page);
    }
  }
}
