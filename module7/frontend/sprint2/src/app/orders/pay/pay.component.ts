import {Component, OnInit} from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';


@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {

  constructor() {
    render(
      {
        id: '#payments',
        currency: 'VNĐ',
        value: '',
        onApprove: (details) => {
          alert("OK");
          console.log(details);
        }
      }
    );
  }

  ngOnInit(): void {
  }

}
