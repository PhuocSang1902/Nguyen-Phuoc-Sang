import {Component, OnInit} from '@angular/core';
import {FacilityService} from '../service/facility.service';
import {Facility} from '../model/facility';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilities: Facility[] = [];
  formSearch: FormGroup;
  temp: Facility = {};

  constructor(private facilityService: FacilityService, private fb: FormBuilder) {
    this.formSearch = this.fb.group({
      search: ['']
    });
    this.getAll(this.formSearch.controls.search.value);
  }

  ngOnInit(): void {
  }

  //lấy danh sách dịch vụ
  getAll(search: string): void {
    this.facilityService.getAll().subscribe(data => {
      this.facilities = data.content;
    }, error => {
    }, () => {
    });
  }

  //tìm kiếm theo tên
  search() {
    this.getAll(this.formSearch.controls.search.value);
  }

  //load lại list
  reloadList() {
    this.getAll(this.formSearch.controls.search.value);
  }
}
