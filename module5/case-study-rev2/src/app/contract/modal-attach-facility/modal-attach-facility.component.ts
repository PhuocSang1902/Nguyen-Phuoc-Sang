import {Component, Input, OnInit} from '@angular/core';
import {ContractService} from '../service/contract.service';
import {ContractDetail} from '../model/contract-detail';
import {Contract} from '../model/contract';

@Component({
  selector: 'app-modal-attach-facility',
  templateUrl: './modal-attach-facility.component.html',
  styleUrls: ['./modal-attach-facility.component.css']
})
export class ModalAttachFacilityComponent implements OnInit {
  @Input('contractDetails') contractDetails: ContractDetail[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }
}
