import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractRoutingModule } from './contract-routing.module';
import { ContractListComponent } from './contract-list/contract-list.component';
import { ContractCreateComponent } from './contract-create/contract-create.component';
import {HomeModule} from '../home/home.module';
import {ReactiveFormsModule} from '@angular/forms';
import { ModalAttachFacilityComponent } from './modal-attach-facility/modal-attach-facility.component';


@NgModule({
  declarations: [ContractListComponent, ContractCreateComponent, ModalAttachFacilityComponent],
    imports: [
        CommonModule,
        ContractRoutingModule,
        HomeModule,
      ReactiveFormsModule
    ]
})
export class ContractModule { }
