import { Component, OnInit } from '@angular/core';
import {CustomerType} from "../customer-type";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import { differenceInYears } from 'date-fns';

@Component({
  selector: 'app-customer-edit-form',
  templateUrl: './customer-edit-form.component.html',
  styleUrls: ['./customer-edit-form.component.css']
})
export class CustomerEditFormComponent implements OnInit {
  customerTypes: CustomerType[] = [
    {id: 1, name: "Diamond"},
    {id: 2, name: "Platinium"},
    {id: 3, name: "Gold"},
    {id: 4, name: "Slive"},
    {id: 5, name: "Member"}];

  createCustomerForm: FormGroup;

  regexIdCard: RegExp = /^[0-9]{9}$|^[0-9]{12}$/;
  regexPhoneNumber: RegExp = /(09)\d{8}|(\+849)\d{8}/;
  regexGender: RegExp = /^Nam$|^Nữ$|^Khác$/;
  regexEmail: RegExp = /[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}/;
  regexDate: RegExp = /^\d{4}-\d{2}-\d{2}$/;
  regexName: RegExp = /^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$/;

  constructor(private formBuilder: FormBuilder) {
    this.createCustomerForm = this.formBuilder.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required, Validators.pattern(this.regexName)]],
      customerType: ['', [Validators.required]],
      birthday: ['', [Validators.required, Validators.pattern(this.regexDate), this.validateBirthday]],
      idCard: ['', [Validators.required, Validators.pattern(this.regexIdCard)]],
      phoneNumber: ['', [Validators.required, Validators.pattern(this.regexPhoneNumber)]],
      gender: ['', [Validators.required, Validators.pattern(this.regexGender)]],
      email: ['', [Validators.required, Validators.pattern(this.regexEmail)]],
      address: ['', [Validators.required]]
    })
  }

  validateBirthday(c: AbstractControl) {
    let date = new Date(c.value);
    let age = differenceInYears(new Date(), date);
    return (age <= 18) ? {'greaterThan18': true} : null;
  }

  ngOnInit(): void {
  }

  submitCustomer() {
    console.log(this.createCustomerForm)
    console.log(this.customerTypes)
  }
}
