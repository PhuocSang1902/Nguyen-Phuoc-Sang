import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  // Tạo biến để nhận dữ liệu từ component cha list
  @Input('customer') customer: Customer = {};
  //Tạo output để goi phương thức reload lại trang list
  @Output() deleteEvent = new EventEmitter();

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
  }

  // Xoá khách hàng
  deleteCustomer() {
    this.customerService.deleteById(this.customer).subscribe(data => {
      this.deleteEvent.emit();
    });
  }
}
