import {Component, OnInit} from '@angular/core';
import {OrdersService} from "../service/orders.service";
import {OrderList} from "../entity/order-list";
import {TokenService} from "../../service/token.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  orderList: OrderList[] = [];
  flagDisplay = false;
  idCustomer: string | null | undefined;
  page = 1;
  constructor(private ordersService: OrdersService,
              private tokenService: TokenService) {
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()){
      this.idCustomer = this.tokenService.getIdCustomer();
    }
    this.getOrderList(Number(this.idCustomer))
  }

  getOrderList(id: number) {
    this.ordersService.getOrderList(id).subscribe(data => {
      this.orderList = data;
      this.flagDisplay = true;
    }, error => {
      this.flagDisplay = false;
    }, () => {
    });
  }
}
