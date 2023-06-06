import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../customer/customer";
import {Employee} from "../../employee/employee";
import {Facility} from "../../facility/facility";
import {differenceInYears} from "date-fns";

@Component({
  selector: 'app-contract-create-form',
  templateUrl: './contract-create-form.component.html',
  styleUrls: ['./contract-create-form.component.css']
})
export class ContractCreateFormComponent implements OnInit {
  contractForm: FormGroup = new FormGroup({});
  regexDate: RegExp = /^\d{4}-\d{2}-\d{2}$/;
  regexNumber: RegExp = /[0-9]*/;

  constructor(private formBuilder: FormBuilder) {
    this.contractForm = this.formBuilder.group({
      id: [''],
      startDate: ['', [Validators.required, Validators.pattern(this.regexDate)]],
      endDate: ['', [Validators.required, Validators.pattern(this.regexDate)]],
      deposit: ['', [Validators.required], Validators.min(0), Validators.pattern(this.regexNumber)],
      customer: ['', [Validators.required]],
      employee: ['', [Validators.required]],
      facility: ['', [Validators.required]]
    }, {validators: this.validateRegisteredDate})
  }

  ngOnInit(): void {
  }

  validateRegisteredDate(c: AbstractControl) {
    let startDate = new Date(c.get('startDate')?.value);
    let endDate = new Date(c.get('endDate')?.value)
    let check = differenceInYears(endDate, startDate);
    return (check < 0) ? {'endDateAfterStartDate': true} : null;
  }

  submitContract() {

  }
}
