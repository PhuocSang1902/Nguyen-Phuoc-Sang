import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SanPhamComponent } from './san-pham/san-pham.component';
import { LoHangComponent } from './lo-hang/lo-hang.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { LoHangCreateComponent } from './lo-hang-create/lo-hang-create.component';
import { LoHangDeleteComponent } from './lo-hang-delete/lo-hang-delete.component';
import { LoHangEditComponent } from './lo-hang-edit/lo-hang-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    SanPhamComponent,
    LoHangComponent,
    LoHangCreateComponent,
    LoHangDeleteComponent,
    LoHangEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
