import {Component, OnInit} from '@angular/core';
import {FacilityService} from '../service/facility.service';
import {FacilityTypeService} from '../service/facility-type.service';
import {RentTypeService} from '../service/rent-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FacilityType} from '../model/facility-type';
import {RentType} from '../model/rent-type';
import {CustomerType} from '../../customer/model/customer-type';

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {
  facilityTypes: FacilityType[] = [];
  rentTypes: RentType[] = [];
  formEditFacility: FormGroup;
  //Khởi tạo regex validate
  regexNumber: RegExp = /^\d*$/;

  constructor(
    private facilityService: FacilityService,
    private facilityTypeService: FacilityTypeService,
    private rentTypeService: RentTypeService,
    private router: Router,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute
  ) {
    this.getAllFacilityType();
    this.getAllRentType();
    this.formEditFacility = this.formBuilder.group({
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
    this.activatedRoute.paramMap.subscribe(result => {
      const id = result.get('id');
      if (id != null) {
        this.getById(Number(id));
      }
    });
  }

  ngOnInit(): void {
  }

  //Kiểm tra loại dịch vụ để xoá giá trị các trường không cần thiết
  checkFacilityType(f: FormGroup) {
    if (f.controls.facilityType.value.name === 'Room') {
      f.controls.standardRoom.reset('');
      f.controls.descriptionOtherConvenience.reset('');
      f.controls.poolArea.reset('');
      f.controls.numberOfFloors.reset('');
    } else if (f.controls.facilityType.value.name === 'House') {
      f.controls.facilityFree.reset('');
      f.controls.poolArea.reset('');
    } else if (f.controls.facilityType.value.name === 'Villa') {
      f.controls.facilityFree.reset('');
    }
  }

  //Cập nhập facility
  submitFacility() {
    this.facilityService.update(this.formEditFacility.value).subscribe(data => {
      this.router.navigateByUrl('/facility');
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

  //Tạo facility theo id
  getById(id: number) {
    this.facilityService.getById(id).subscribe(data => {
      this.formEditFacility.patchValue(data);
    }, error => {
    }, () => {
    });
  }

  //Phương thức để select chọn theo giá trị
  compareWith(o1: CustomerType, o2: CustomerType): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }
}
