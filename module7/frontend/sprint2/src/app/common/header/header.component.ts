import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {TokenService} from "../../service/token.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ProductService} from "../../product/service/product.service";
import {OrdersService} from "../../orders/service/orders.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class HeaderComponent implements OnInit {
  checkLogin = false;
  name: string | null | undefined;
  roles: string[] = [];
  idAccount: string | null | undefined;
  searchForm: FormGroup;
  page = 0;
  kindOfBook = "";
  totalProduct = 0;
  email: string | null | undefined;

  constructor(private tokenService: TokenService,
              private router: Router,
              private fb: FormBuilder,
              private productService: ProductService,
              private ordersService: OrdersService,
              private cd: ChangeDetectorRef) {
    this.searchForm = this.fb.group({
      search: [""]
    })
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.name = this.tokenService.getName();
      this.roles = this.tokenService.getRole();
      this.idAccount = this.tokenService.getId();
      this.email = this.tokenService.getEmail();
    }
    this.getTotalProduct();
  }

  logOut(): void {
    window.localStorage.clear();
    this.router.navigateByUrl('/').then(() => {
      location.reload();
    });
  }

  search() {
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    // this.router.navigateByUrl("/")
  }

  home() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = ""
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  politicsLaw() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = "Chính trị-Pháp luật"
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  scienceEconomy() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = "Khoa học-Kinh tế"
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  literatureArt() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = "Văn học-Nghệ thuật"
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  socialCultureHistory() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = "Văn hoá xã hội-Lịch sử"
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  mentalityReligion() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = "Tâm lý-Tôn giáo"
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  storyNovel() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = "Truyện-Tiểu thuyết"
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  children() {
    this.searchForm.patchValue({search: ""})
    this.kindOfBook = "Sách thiếu nhi"
    this.productService.getListForHomePage(this.searchForm.controls.search.value, this.kindOfBook, this.page);
    this.router.navigateByUrl("/")
  }

  getTotalProduct() {
    this.ordersService.totalCartBehaviorSubject.subscribe(data => {
      if (data != null) {
        this.totalProduct = data;
      } else {
        this.totalProduct = 0;
      }
      this.cd.markForCheck();
    }, error => {
      this.totalProduct = 0;
    }, () => {
    })
  }
}
