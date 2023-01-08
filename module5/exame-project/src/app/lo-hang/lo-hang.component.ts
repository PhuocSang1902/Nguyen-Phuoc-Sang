import {Component, OnInit} from '@angular/core';
import {LoHangService} from '../service/lo-hang.service';
import {LoHang} from '../model/lo-hang';
import {FormBuilder, FormGroup} from '@angular/forms';
import {SanPhamService} from '../service/san-pham.service';
import {SanPham} from '../model/san-pham';

@Component({
  selector: 'app-lo-hang',
  templateUrl: './lo-hang.component.html',
  styleUrls: ['./lo-hang.component.css']
})
export class LoHangComponent implements OnInit {
  loHangs: LoHang[] = [];
  temp: LoHang = {};
  sanPhamList: SanPham[] = [];
  page: number = 0;
  totalPage: number = 0;
  size: number = 0;
  formSearch: FormGroup = this.fb.group({});

  constructor(private loHangService: LoHangService,
              private fb: FormBuilder,
              private sanPhamService: SanPhamService) {
    this.formSearch = this.fb.group({
      name: [''],
      ngayHetHan: ['']
    });
    this.getAllLoHang(this.page);
    this.getAllSanPham();
  }

  ngOnInit(): void {
  }

  //Lấy danh sách lô hàng
  getAllLoHang(page: number) {
    this.loHangService.getAllLoHang(page).subscribe(data => {
      this.loHangs = data['content'];
      this.totalPage = data['totalPages'];
      this.page = data['number'];
      this.size = data['size'];
    }, error => {
    }, () => {
    });
  }

  search() {
    this.loHangService.searchLoHang(this.formSearch.controls.name.value, this.formSearch.controls.ngayHetHan.value).subscribe(data => {
      this.loHangs = data;
    }, error => {
    }, () => {
    });
  }

  //Phương thức load lại danh sách
  reloadList() {
    this.getAllLoHang(this.page);
  }

  //Phương thức lấy danh sách sản phẩm
  getAllSanPham() {
    this.sanPhamService.getAll().subscribe(data => {
      this.sanPhamList = data;
    }, error => {
    }, () => {
    });
  }

  //Phương thức để select chọn theo giá trị
  compareWith(o1: SanPham, o2: SanPham): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

  //Tới trang sau
  nextPage() {
    if (this.page < this.totalPage - 1) {
      this.page = this.page + 1;
      this.getAllLoHang(this.page);
    }
  }

  //Quay lại trang trước  nextPage() {
  previousPage() {
    if (this.page > 0) {
      this.page = this.page - 1;
      this.getAllLoHang(this.page);
    }
  }
}
