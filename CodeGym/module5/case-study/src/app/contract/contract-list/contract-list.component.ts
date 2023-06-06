import {Component, OnInit} from '@angular/core';
import {Division} from "../../employee/division";
import {Position} from "../../employee/position";
import {EducationDegree} from "../../employee/education-degree";
import {Employee} from "../../employee/employee";
import {Contract} from "../contract";
import {CustomerListComponent} from "../../customer/customer-list/customer-list.component";
import {Customer} from "../../customer/customer";
import {Facility} from "../../facility/facility";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  division: Division[] = [
    {id: 1, name: "Sale-Marketing"}, {id: 2, name: "Hành chính"}, {id: 3, name: "Phục vụ"}, {id: 4, name: "Quản lý"}
  ]
  position: Position[] = [
    {id: 1, name: "Quản Lý"}, {id: 2, name: "Nhân Viên"}
  ]
  educationDegree: EducationDegree[] = [
    {id: 1, name: "Trung Cấp"}, {id: 2, name: "Cao Đẳng"}, {id: 3, name: "Đại Học"}, {id: 4, name: "Sau Đại Học"}
  ]
  employees: Employee[] = [
    {
      id: 1,
      name: "Nguyễn Văn An",
      birthday: "1970-11-07",
      division: this.division[0],
      educationDegree: this.educationDegree[2],
      position: this.position[0],
      idCard: "456231786",
      salary: 10000000,
      phoneNumber: "0901234121",
      email: "annguyen@gmail.com",
      address: "295 Nguyễn Tất Thành, Đà Nẵng",
      flagDelete: false
    },
    {
      id: 2,
      name: "Lê Văn Bình",
      birthday: "1997-04-09",
      division: this.division[1],
      educationDegree: this.educationDegree[1],
      position: this.position[0],
      idCard: "654231234",
      salary: 7000000,
      phoneNumber: "0934212314",
      email: "binhlv@gmail.com",
      address: "22 Yên Bái, Đà Nẵng",
      flagDelete: false
    },
    {
      id: 3,
      name: "Hồ Thị Yến",
      birthday: "1995-12-12",
      division: this.division[1],
      educationDegree: this.educationDegree[2],
      position: this.position[0],
      idCard: "999231723",
      salary: 14000000,
      phoneNumber: "0412352315",
      email: "thiyen@gmail.com",
      address: "K234/11 Điện Biên Phủ, Gia Lai",
      flagDelete: false
    },
    {
      id: 4,
      name: "Võ Công Toản",
      birthday: "1980-04-04",
      division: this.division[3],
      educationDegree: this.educationDegree[3],
      position: this.position[1],
      idCard: "123231365",
      salary: 17000000,
      phoneNumber: "0374443232",
      email: "toan0404@gmail.com",
      address: "77 Hoàng Diệu, Quảng Trị",
      flagDelete: false
    },
    {
      id: 5,
      name: "Nguyễn Bỉnh Phát",
      birthday: "1999-12-09",
      division: this.division[0],
      educationDegree: this.educationDegree[0],
      position: this.position[1],
      idCard: "454363232",
      salary: 6000000,
      phoneNumber: "0902341231",
      email: "phatphat@gmail.com",
      address: "43 Yên Bái, Đà Nẵng",
      flagDelete: false
    },
    {
      id: 6,
      name: "Khúc Nguyễn An Nghi",
      birthday: "2000-11-08",
      division: this.division[2],
      educationDegree: this.educationDegree[1],
      position: this.position[1],
      idCard: "964542311",
      salary: 7000000,
      phoneNumber: "0978653213",
      email: "annghi20@gmail.com",
      address: "294 Nguyễn Tất Thành, Đà Nẵng",
      flagDelete: false
    },
    {
      id: 7,
      name: "Nguyễn Hữu Hà",
      birthday: "1993-01-01",
      division: this.division[1],
      educationDegree: this.educationDegree[2],
      position: this.position[1],
      idCard: "534323231",
      salary: 8000000,
      phoneNumber: "0941234553",
      email: "nhh0101@gmail.com",
      address: "4 Nguyễn Chí Thanh, Huế",
      flagDelete: false
    },
    {
      id: 8,
      name: "Nguyễn Hà Đông",
      birthday: "1989-09-03",
      division: this.division[3],
      educationDegree: this.educationDegree[3],
      position: this.position[1],
      idCard: "234414123",
      salary: 9000000,
      phoneNumber: "0642123111",
      email: "donghanguyen@gmail.com",
      address: "111 Hùng Vương, Hà Nội",
      flagDelete: false
    },
    {
      id: 9,
      name: "Tòng Hoang",
      birthday: "1982-09-03",
      division: this.division[3],
      educationDegree: this.educationDegree[3],
      position: this.position[1],
      idCard: "256781231",
      salary: 6000000,
      phoneNumber: "0245144444",
      email: "hoangtong@gmail.com",
      address: "213 Hàm Nghi, Đà Nẵng",
      flagDelete: false
    },
    {
      id: 10,
      name: "Nguyễn Công Đạo",
      birthday: "1994-01-08",
      division: this.division[1],
      educationDegree: this.educationDegree[2],
      position: this.position[1],
      idCard: "755434343",
      salary: 8000000,
      phoneNumber: "0988767111",
      email: "nguyencongdao12@gmail.com",
      address: "6 Hoà Khánh, Đồng Nai",
      flagDelete: false
    }
  ]
  customers: Customer[] = [
    {id: 1, name: "Nguyễn Thị Hào"},
    {id: 2, name: "Phạm Xuân Diệu"},
    {id: 3, name: "Trương Đình Nghệ"},
    {id: 4, name: "Dương Văn Quan"},
    {id: 5, name: "Hoàng Trần Nhi Nhi"},
    {id: 6, name: "Tôn Nữ Mộc Châu"},
    {id: 7, name: "Nguyễn Mỹ Kim"},
    {id: 8, name: "Nguyễn Thị Hào"},
    {id: 9, name: "Trần Đại Danh"},
    {id: 10, name: "Nguyễn Tâm Đắc"}
  ]
  facilities: Facility[] = [
    {id: 1, name: "Villa Beach Front"},
    {id: 2, name: "House Princess 01"},
    {id: 3, name: "Room Twin 01"},
    {id: 4, name: "Villa No Beach Front"},
    {id: 5, name: "House Princess 02"},
    {id: 6, name: "Room Twin 02",},
  ]
  contracts: Contract[] = [
    {
      id: 1,
      deposit: 0,
      startDate: "2020-12-08",
      endDate: "2020-12-08",
      customer: this.customers[0],
      employee: this.employees[2],
      facility: this.facilities[2]
    },
    {
      id: 2,
      deposit: 200000,
      startDate: "2020-07-14",
      endDate: "2020-07-21",
      customer: this.customers[2],
      employee: this.employees[6],
      facility: this.facilities[0]
    },
    {
      id: 3,
      deposit: 50000,
      startDate: "2021-03-15",
      endDate: "2021-03-17",
      customer: this.customers[3],
      employee: this.employees[2],
      facility: this.facilities[1]
    },
    {
      id: 4,
      deposit: 100000,
      startDate: "2021-01-14",
      endDate: "2021-01-18",
      customer: this.customers[4],
      employee: this.employees[6],
      facility: this.facilities[4]
    },
    {
      id: 5,
      deposit: 0,
      startDate: "2021-07-14",
      endDate: "2021-07-15",
      customer: this.customers[1],
      employee: this.employees[6],
      facility: this.facilities[5]
    },
    {
      id: 6,
      deposit: 0,
      startDate: "2021-06-01",
      endDate: "2021-06-03",
      customer: this.customers[6],
      employee: this.employees[6],
      facility: this.facilities[5]
    },
    {
      id: 7,
      deposit: 100000,
      startDate: "2021-09-028",
      endDate: "2021-09-05",
      customer: this.customers[3],
      employee: this.employees[6],
      facility: this.facilities[3]
    },
    {
      id: 8,
      deposit: 150000,
      startDate: "2021-06-17",
      endDate: "2021-06-18",
      customer: this.customers[3],
      employee: this.employees[2],
      facility: this.facilities[0]
    },
    {
      id: 9,
      deposit: 0,
      startDate: "2020-11-19",
      endDate: "2020-11-19",
      customer: this.customers[3],
      employee: this.employees[2],
      facility: this.facilities[2]
    },
    {
      id: 10,
      deposit: 0,
      startDate: "2021-04-12",
      endDate: "2021-04-14",
      customer: this.customers[2],
      employee: this.employees[9],
      facility: this.facilities[4]
    },
    {
      id: 11,
      deposit: 0,
      startDate: "2021-04-25",
      endDate: "2021-04-25",
      customer: this.customers[1],
      employee: this.employees[1],
      facility: this.facilities[0]
    },
    {
      id: 12,
      deposit: 0,
      startDate: "2021-05-25",
      endDate: "2021-05-278",
      customer: this.customers[9],
      employee: this.employees[6],
      facility: this.facilities[0]
    }
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
