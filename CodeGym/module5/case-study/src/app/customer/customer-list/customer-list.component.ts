import {Component, OnInit} from '@angular/core';
import {CustomerType} from "../customer-type";
import {Customer} from "../customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerType: CustomerType[] = [
    {id: 1, name: "Diamond"},
    {id: 2, name: "Platinium"},
    {id: 3, name: "Gold"},
    {id: 4, name: "Slive"},
    {id: 5, name: "Member"}];
  customers: Customer[] = [
    {
      id: 1,
      name: "Nguyễn Thị Hào",
      customerType: this.customerType[4],
      birthday: "1970-11-07",
      idCard: 643431213,
      phoneNumber: "0945423362",
      gender: "Nữ",
      email: "thihao07@gmail.com",
      address: "23 Nguyễn Hoàng, Đà Nẵng",
      flagDelete: false
    },
    {
      id: 2,
      name: "Phạm Xuân Diệu",
      customerType: this.customerType[2],
      birthday: "1992-08-08",
      idCard: 865342123,
      phoneNumber: "0954333333",
      gender: "Nam",
      email: "xuandieu92@gmail.com",
      address: "K77/22 Thái Phiên, Quảng Trị",
      flagDelete: false
    },
    {
      id: 3,
      name: "Trương Đình Nghệ",
      customerType: this.customerType[0],
      birthday: "1990-02-27",
      idCard: 488645199,
      phoneNumber: "0373213122",
      gender: "Nam",
      email: "nghenhan2702@gmail.com",
      address: "K323/12 Ông Ích Khiêm, Vinh",
      flagDelete: false
    },
    {
      id: 4,
      name: "Dương Văn Quan",
      customerType: this.customerType[0],
      birthday: "1981-07-08",
      idCard: 543432111,
      phoneNumber: "0490039241",
      gender: "Nam",
      email: "duongquan@gmail.com",
      address: "K453/12 Lê Lợi, Đà Nẵng",
      flagDelete: false
    },
    {
      id: 5,
      name: "Hoàng Trần Nhi Nhi",
      customerType: this.customerType[3],
      birthday: "1995-12-09",
      idCard: 543432111,
      phoneNumber: "795453345",
      gender: "Nữ",
      email: "nhinhi123@gmail.com",
      address: "224 Lý Thái Tổ, Gia Lai",
      flagDelete: false
    },
    {
      id: 6,
      name: "Tôn Nữ Mộc Châu",
      customerType: this.customerType[3],
      birthday: "2005-12-06",
      idCard: 732434215,
      phoneNumber: "0988888844",
      gender: "Nữ",
      email: "tonnuchau@gmail.com",
      address: "37 Yên Thế, Đà Nẵng",
      flagDelete: false
    }
  ]
  temp: Customer = {};

  constructor() {
  }

  ngOnInit()
    :
    void {
  }

}
