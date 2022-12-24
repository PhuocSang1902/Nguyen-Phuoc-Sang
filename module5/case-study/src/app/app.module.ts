import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';
import { HomeComponent } from './common/home/home.component';
import { NavComponent } from './common/nav/nav.component';
import { FacilityListComponent } from './facility/facility-list/facility-list.component';
import { EditFormFacilityComponent } from './facility/edit-form-facility/edit-form-facility.component';
import { CreateFormFacilityComponent } from './facility/create-form-facility/create-form-facility.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavComponent,
    FacilityListComponent,
    EditFormFacilityComponent,
    CreateFormFacilityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
