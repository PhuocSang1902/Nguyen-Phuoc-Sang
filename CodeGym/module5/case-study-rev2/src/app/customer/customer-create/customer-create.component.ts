import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {differenceInYears} from 'date-fns';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';
import {CustomerType} from '../model/customer-type';
import {CustomerTypeService} from '../service/customer-type.service';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  createCustomerForm = this.formBuilder.group({});
  customerTypes: CustomerType[] = [];
  regexIdCard: RegExp = /^[0-9]{9}$|^[0-9]{12}$/;
  regexIdCustomer: RegExp = /^(KH-)[0-9]{4}$/;
  regexPhoneNumber: RegExp = /(09)\d{8}|(\+849)\d{8}/;
  regexGender: RegExp = /^Nam$|^Nữ$|^Khác$/;
  regexEmail: RegExp = /\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+/;
  regexDate: RegExp = /^\d{4}-\d{2}-\d{2}$/;
  regexName: RegExp = /^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$/;

  constructor(private formBuilder: FormBuilder,
              private customerService: CustomerService,
              private route: Router,
              private  customerTypeService: CustomerTypeService) {
    this.createCustomerForm = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern(this.regexIdCustomer)]],
      name: ['', [Validators.required, Validators.pattern(this.regexName)]],
      customerType: [{}, [Validators.required]],
      birthday: ['', [Validators.required, Validators.pattern(this.regexDate), this.validateBirthday]],
      idCard: ['', [Validators.required, Validators.pattern(this.regexIdCard)]],
      phoneNumber: ['', [Validators.required, Validators.pattern(this.regexPhoneNumber)]],
      gender: ['', [Validators.required, Validators.pattern(this.regexGender)]],
      email: ['', [Validators.required, Validators.pattern(this.regexEmail)]],
      address: ['', [Validators.required]],
      flagDelete: ['true']
    });
    this.getAllCustomerType();
  }

  ngOnInit(): void {
  }
  //Phương thức để select chọn theo giá trị
  compareWith(o1: CustomerType, o2: CustomerType): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }
  //Validate ngày sinh phải lớn hơn 18 tuổi
  validateBirthday(c: AbstractControl): any {
    const date = new Date(c.value);
    const age = differenceInYears(new Date(), date);
    return (age <= 18) ? {greaterThan18: true} : null;
  }

  createCustomer(): any {
    this.customerService.create(this.createCustomerForm.value).subscribe(data => {
      this.route.navigateByUrl('/customer');
    }, error => {
    }, () => {
    });
  }

  getAllCustomerType(): void {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypes = data;
      console.log(this.customerTypes);
    }, error => {
    }, () => {
    });
  }
}
