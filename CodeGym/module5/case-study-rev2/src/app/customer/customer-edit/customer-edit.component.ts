import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../model/customer-type';
import {AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {CustomerService} from '../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerTypeService} from '../service/customer-type.service';
import {differenceInYears} from 'date-fns';
import {Customer} from '../model/customer';
import {variable} from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  // tạo form reactive
  editCustomerForm = this.formBuilder.group({});
  customerTypes: CustomerType[] = [];
  // Tạo regex validate
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
              private activatedRoute: ActivatedRoute,
              private  customerTypeService: CustomerTypeService) {
    // tạo form control cho reactive form
    this.editCustomerForm = this.formBuilder.group({
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
    // lấy khách hàng theo id nhận từ path variable và gán gái trị cho form
    this.activatedRoute.paramMap.subscribe(result => {
      const id = result.get('id');
      if (id != null) {
        this.getCustomerById(parseInt(id));
      }
    }, error => {
    }, () => {
    });
  }

  ngOnInit(): void {
  }

  // phương thức để select chọn theo value có sán
  compareWith(o1: CustomerType, o2: CustomerType): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

// kiếm tra ngày sinh không được nhỏ hơn 18
  validateBirthday(c: AbstractControl): any {
    const date = new Date(c.value);
    const age = differenceInYears(new Date(), date);
    return (age <= 18) ? {greaterThan18: true} : null;
  }

// Cập nhập khách hàng vào danh sách và trả về tra list
  updateCustomer(): any {
    this.customerService.update(this.editCustomerForm.value).subscribe(data => {
      this.route.navigateByUrl('/customer');
    }, error => {
    }, () => {
    });
  }

// lấy khách hàng theo id và gán giá trị vào form
  getCustomerById(id: number): void {
    this.customerService.getById(id).subscribe(data => {
      this.editCustomerForm.patchValue(data);
    }, error => {
    }, () => {
    });
  }

// lấy danh sách loại khách hàng
  getAllCustomerType(): void {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypes = data;
    }, error => {
    }, () => {
    });
  }
}
