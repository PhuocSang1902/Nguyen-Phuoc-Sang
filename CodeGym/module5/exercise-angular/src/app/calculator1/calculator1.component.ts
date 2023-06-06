import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'calculator1',
  templateUrl: './calculator1.component.html',
  styleUrls: ['./calculator1.component.css']
})
export class Calculator1Component implements OnInit {
  private num1: number = 0;
  private num2: number = 0;
  private operator: string = '';
  public result: string = '';

  constructor() {
  }

  ngOnInit(): void {
  }

  getNum1(target: any): number {
    this.num1 = parseInt(target.value);
    return this.num1;
  }


  getNum2(target: any): number {
    this.num2 = parseInt(target.value);
    return this.num2;
  }

  getOperator(target: any): string {
    this.operator = target.value;
    return this.operator;
  }


  getResult(operator: string): string {
    this.operator = operator;
    switch (this.operator) {
      case '+':
        this.result = String(this.num1 + this.num2);
        break;
      case '-':
        this.result = String(this.num1 - this.num2);
        break;
      case '*':
        this.result = String(this.num1 * this.num2);
        break;
      case '/':
        this.result = String(this.num1 / this.num2);
        break;
      default:
        this.result = '';
    }
    return this.result;
  }
}
