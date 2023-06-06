import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {LoHang} from '../model/lo-hang';
import {LoHangService} from '../service/lo-hang.service';

@Component({
  selector: 'app-lo-hang-delete',
  templateUrl: './lo-hang-delete.component.html',
  styleUrls: ['./lo-hang-delete.component.css']
})
export class LoHangDeleteComponent implements OnInit {
  // Tạo biến để nhận dữ liệu từ component cha list
  @Input('loHang') loHang: LoHang = {};
  //Tạo output để goi phương thức reload lại trang list
  @Output() deleteEvent = new EventEmitter();

  constructor(private loHangService: LoHangService) {
  }

  ngOnInit(): void {
  }

  //Phương thức xoá lô hàng
  deleteCustomer() {
    this.loHangService.deleteLoHang(this.loHang).subscribe(data => {
      this.deleteEvent.emit();
    }, error => {
    }, () => {
    });
  }
}
