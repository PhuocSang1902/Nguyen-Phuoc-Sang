import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';

@Component({
  selector: 'app-customer-use-facility',
  templateUrl: './customer-use-facility.component.html',
  styleUrls: ['./customer-use-facility.component.css']
})
export class CustomerUseFacilityComponent implements OnInit {
  formSearch: FormGroup;
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
      this.customerService.getAllUseFacilityBySearch(this.page, search).subscribe(data => {
        this.customers = data['content'];
        this.totalPage = data['totalPages'];
        this.page = data.pageable['pageNumber'];
        this.size = data['size'];
      }, error => {
      }, () => {
      });
    } else {
      this.customerService.getAllUseFacility(this.page).subscribe(data => {
        console.log(data);
        this.customers = data['content'];
        this.totalPage = data['totalPages'];
        this.page = data.pageable['pageNumber'];
        this.size = data['size'];
      }, error => {
      }, () => {
      });
    }

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
