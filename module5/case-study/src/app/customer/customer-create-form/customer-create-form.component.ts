import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer-create-form',
  templateUrl: './customer-create-form.component.html',
  styleUrls: ['./customer-create-form.component.css']
})
export class CustomerCreateFormComponent implements OnInit {
  private formBuilder: FormBuilder;
  createCustomerForm: FormGroup;
  constructor() {
    this.createCustomerForm = this.formBuilder.group({

    })
  }

  ngOnInit(): void {
  }

}
