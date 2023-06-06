import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Contract} from '../model/contract';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AttachFacility} from '../model/attach-facility';
import {ContractService} from '../service/contract.service';
import {Router} from '@angular/router';
import {CustomerType} from '../../customer/model/customer-type';
import {Customer} from '../../customer/model/customer';
import {Employee} from '../../employee/model/employee';
import {Facility} from '../../facility/model/facility';

@Component({
  selector: 'app-modal-add-contract-detail',
  templateUrl: './modal-add-contract-detail.component.html',
  styleUrls: ['./modal-add-contract-detail.component.css']
})
export class ModalAddContractDetailComponent implements OnInit, OnChanges {
  @Input('contract') contract: Contract = {};
  @Output() addEvent = new EventEmitter();
  formAddContractDetail: FormGroup = this.fb.group({
    id: [''],
    contract: [{}],
    attachFacility: [{}],
    quantity: [''],
  });
  attachFacilities: AttachFacility[] = [];

  constructor(private fb: FormBuilder, private contractService: ContractService, private route: Router) {
  }

  ngOnInit(): void {

    this.getAttachFacility();
  }

  addContractDetail() {

    this.contractService.addContractDetail(this.formAddContractDetail.value).subscribe(data => {
      this.addEvent.emit();
    }, error => {
    }, () => {
    });
  }

  getAttachFacility() {
    this.contractService.getAllAttachFacility().subscribe(data => {
      this.attachFacilities = data;
    }, error => {
    }, () => {
    });
  }

  //Phương thức để select chọn theo giá trị
  compareWith(o1: CustomerType, o2: CustomerType): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.contract);
    this.formAddContractDetail.patchValue({contract: this.contract});
    console.log(this.formAddContractDetail.value);
  }
}
