import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from '../../customer/model/customer';
import {Facility} from '../model/facility';
import {FacilityService} from '../service/facility.service';

@Component({
  selector: 'app-facility-delete',
  templateUrl: './facility-delete.component.html',
  styleUrls: ['./facility-delete.component.css']
})
export class FacilityDeleteComponent implements OnInit {
  // Tạo biến để nhận dữ liệu từ component cha list
  @Input('facility') facility: Facility = {};
  //Tạo output để goi phương thức reload lại trang list
  @Output() deleteEvent = new EventEmitter();

  constructor(private facilityService: FacilityService) {
  }

  ngOnInit(): void {
  }

  deleteFacility() {
    this.facilityService.deleteById(this.facility).subscribe(data => {
      this.deleteEvent.emit();
    });
  }
}
