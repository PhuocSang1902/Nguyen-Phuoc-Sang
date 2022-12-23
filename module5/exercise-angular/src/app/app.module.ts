import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Calculator1Component } from './calculator1/calculator1.component';
import { ColorPickComponent } from './color-pick/color-pick.component';

@NgModule({
  declarations: [
    AppComponent,
    Calculator1Component,
    ColorPickComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
