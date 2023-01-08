import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SanPham} from '../model/san-pham';
import {differenceInDays, differenceInYears} from 'date-fns';
import {LoHangService} from '../service/lo-hang.service';
import {Router} from '@angular/router';
import {SanPhamService} from '../service/san-pham.service';

@Component({
  selector: 'app-lo-hang-create',
  templateUrl: './lo-hang-create.component.html',
  styleUrls: ['./lo-hang-create.component.css']
})
export class LoHangCreateComponent implements OnInit {
  sanPhamList: SanPham[] = [];
  formCreateLoHang: FormGroup = this.fb.group({});
  //Regex validate
  regexMa: RegExp = /^(LH-)\d{4}$/;
  regexDate: RegExp = /^\d{4}-\d{2}-\d{2}$/;

  constructor(private fb: FormBuilder,
              private loHangService: LoHangService,
              private router: Router,
              private sanPhamService: SanPhamService) {
    this.formCreateLoHang = this.fb.group({
      ma: ['', [Validators.required, Validators.pattern(this.regexMa)]],
      sanPham: [{}, [Validators.required]],
      soLuong: ['', [Validators.required, Validators.min(1)]],
      ngayNhapHang: ['', [Validators.required, Validators.pattern(this.regexDate)]],
      ngaySanXuat: ['', [Validators.required, Validators.pattern(this.regexDate)]],
      ngayHetHan: ['', [Validators.required, Validators.pattern(this.regexDate)]]
    }, {validators: this.validateRegisteredDate});
    this.getAllSanPham();
  }

  //Phương thức để select chọn theo giá trị
  compareWith(o1: SanPham, o2: SanPham): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

  // Validate ngày sản xuất phải trước ngày nhập hàng và ngày hết hàng sau ngày nhập hàng
  validateRegisteredDate(c: AbstractControl) {
    let ngayNhapHang = new Date(c.get('ngayNhapHang')?.value);
    let NgayHetHan = new Date(c.get('ngayHetHan')?.value);
    let NgaySanXuat = new Date(c.get('ngaySanXuat')?.value);
    let check = differenceInDays(NgayHetHan, ngayNhapHang);
    let check2 = differenceInDays(ngayNhapHang, NgaySanXuat);
    return (check < 0 || check2 < 0) ? {'endDateAfterStartDate': true} : null;
  }

  ngOnInit(): void {
  }

  //Phương thức lưu lô hàng tạo mới
  createLoHang() {
    this.loHangService.createLoHang(this.formCreateLoHang.value).subscribe(data => {
      this.router.navigateByUrl('');
    }, error => {
    }, () => {
    });
  }

  //Phương thức lấy danh sách sản phẩm
  getAllSanPham() {
    this.sanPhamService.getAll().subscribe(data => {
      this.sanPhamList = data;
    }, error => {
    }, () => {
    });
  }
}
