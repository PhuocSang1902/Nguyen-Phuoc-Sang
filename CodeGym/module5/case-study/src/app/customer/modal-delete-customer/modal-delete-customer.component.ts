import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {Contract} from "../../contract/contract";
import {Customer} from "../customer";

@Component({
  selector: 'app-modal-delete-customer',
  templateUrl: './modal-delete-customer.component.html',
  styleUrls: ['./modal-delete-customer.component.css']
})
export class ModalDeleteCustomerComponent implements OnInit {
  modalForm: FormGroup = new FormGroup({});
  @Input("customer")
  customer: Customer = {};

  constructor() {
  }

  ngOnInit(): void {
  }

  deleteId() {

  }
}
