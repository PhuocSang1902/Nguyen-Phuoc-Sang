import {Component, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';
import {CustomerType} from '../model/customer-type';
import {CustomerTypeService} from '../service/customer-type.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  temp: Customer = {};
  customers: Customer[] = [];
  customerTypes: CustomerType[] = [];

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getAll();
  }
// lấy danh sách khách hàng
  getAll(): void {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    }, error => {
    }, () => {
    });
  }

//load lại list
  reloadList() {
    this.getAll()
  }
}
