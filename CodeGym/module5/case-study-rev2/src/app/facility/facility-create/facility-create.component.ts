import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FacilityService} from '../service/facility.service';
import {Router} from '@angular/router';
import {FacilityType} from '../model/facility-type';
import {RentType} from '../model/rent-type';
import {FacilityTypeService} from '../service/facility-type.service';
import {RentTypeService} from '../service/rent-type.service';
import {CustomerType} from '../../customer/model/customer-type';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  facilityTypes: FacilityType[] = [];
  rentTypes: RentType[] = [];
  //Khởi tạo reactive form
  formCreateFacility = this.formBuilder.group({});
  //Khởi tạo regex validate
  regexNumber: RegExp = /^\d*$/;

  constructor(private formBuilder: FormBuilder,
              private facilityService: FacilityService,
              private route: Router,
              private facilityTypeService: FacilityTypeService,
              private rentTypeService: RentTypeService
  ) {
    this.getAllFacilityType();
    this.getAllRentType();
    this.formCreateFacility = this.formBuilder.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required]],
      area: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      cost: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      maxPeople: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      facilityType: [{}, [Validators.required]],
      rentType: [{}, [Validators.required]],
      standardRoom: ['', [Validators.required]],
      descriptionOtherConvenience: ['', [Validators.required]],
      poolArea: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      numberOfFloors: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      facilityFree: ['', [Validators.required]],
      flagDelete: [true],
    });
  }

  ngOnInit(): void {
  }

  //Tạo mới facility
  submitFacility() {
    this.facilityService.create(this.formCreateFacility.value).subscribe(data => {
      this.route.navigateByUrl('/facility');
    }, error => {
    }, () => {
    });
  }

  //Tạo danh sách facilityType
  getAllFacilityType() {
    this.facilityTypeService.getAll().subscribe(data => {
      this.facilityTypes = data;
    }, error => {
    }, () => {
    });
  }

  //Tạo danh sách rent type
  getAllRentType() {
    this.rentTypeService.getAll().subscribe(data => {
      this.rentTypes = data;
    }, error => {
    }, () => {
    });
  }
  //Kiểm tra loại dịch vụ để xoá giá trị các trường không cần thiết
  checkFacilityType(f: FormGroup){
    if (f.controls.facilityType.value.name === "Room"){
      f.controls.standardRoom.reset("");
      f.controls.descriptionOtherConvenience.reset("");
      f.controls.poolArea.reset("");
      f.controls.numberOfFloors.reset("");
    }else if (f.controls.facilityType.value.name === "House"){
      f.controls.facilityFree.reset("");
      f.controls.poolArea.reset("");
    }else if (f.controls.facilityType.value.name === "Villa"){
      f.controls.facilityFree.reset("");
    }
  }
  //Phương thức để select chọn theo giá trị
  compareWith(o1: CustomerType, o2: CustomerType): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }
}
