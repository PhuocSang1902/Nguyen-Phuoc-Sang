import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';
import { HomeComponent } from './common/home/home.component';
import { NavComponent } from './common/nav/nav.component';
import { FacilityListComponent } from './facility/facility-list/facility-list.component';
import { FacilityEditFormComponent } from './facility/facility-edit-form/facility-edit-form.component';
import { FacilityCreateFormComponent } from './facility/facility-create-form/facility-create-form.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerEditFormComponent } from './customer/customer-edit-form/customer-edit-form.component';
import { CustomerCreateFormComponent } from './customer/customer-create-form/customer-create-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavComponent,
    FacilityListComponent,
    FacilityEditFormComponent,
    FacilityCreateFormComponent,
    CustomerListComponent,
    CustomerEditFormComponent,
    CustomerCreateFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
