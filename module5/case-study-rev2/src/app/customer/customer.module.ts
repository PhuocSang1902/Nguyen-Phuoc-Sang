import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { CustomerDeleteComponent } from './customer-delete/customer-delete.component';
import {HomeModule} from '../home/home.module';
import {ReactiveFormsModule} from '@angular/forms';
import { CustomerUseFacilityComponent } from './customer-use-facility/customer-use-facility.component';


@NgModule({
  declarations: [CustomerListComponent, CustomerEditComponent, CustomerCreateComponent, CustomerDeleteComponent, CustomerUseFacilityComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    HomeModule,
    ReactiveFormsModule
  ]
})
export class CustomerModule { }
