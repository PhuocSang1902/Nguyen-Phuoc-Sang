import {Component, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';
import {CustomerType} from '../model/customer-type';
import {CustomerTypeService} from '../service/customer-type.service';
import {ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  formSearch: FormGroup;
  temp: Customer = {};
  customers: Customer[] = [];
  page: number = 0;
  totalPage: number = 0;
  size: number = 0;

  constructor(private customerService: CustomerService, private fb: FormBuilder) {
    this.formSearch = this.fb.group({
      search: ['']
    });
  }

  ngOnInit(): void {
    this.getAll(this.page, this.formSearch.controls.search.value);
  }

  // lấy danh sách khách hàng
  getAll(page: number, search: string): void {
    if (search !== '') {
      this.customerService.getAllBySearch(this.page, search).subscribe(data => {
        this.customers = data['content'];
        this.totalPage = data['totalPages'];
        this.page = data.pageable['pageNumber'];
        this.size = data['size'];
      }, error => {
      }, () => {
      });
    } else {
      this.customerService.getAll(this.page).subscribe(data => {
        this.customers = data['content'];
        this.totalPage = data['totalPages'];
        this.page = data.pageable['pageNumber'];
        this.size = data['size'];
      }, error => {
      }, () => {
      });
    }
  }

  //load lại list
  reloadList() {
    this.getAll(this.page, this.formSearch.controls.search.value);
  }

  //Tới trang sau
  nextPage() {
    if (this.page < this.totalPage - 1) {
      this.page = this.page + 1;
      this.getAll(this.page, this.formSearch.controls.search.value);
    }
  }

  //Quay lại trang trước  nextPage() {
  previousPage() {
    if (this.page > 0) {
      this.page = this.page - 1;
      this.getAll(this.page, this.formSearch.controls.search.value);
    }
  }

  //tìm kiếm theo tên
  search() {
    this.getAll(this.page, this.formSearch.controls.search.value);
  }
}
