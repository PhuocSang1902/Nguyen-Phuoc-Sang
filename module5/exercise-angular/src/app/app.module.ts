import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Calculator1Component } from './calculator1/calculator1.component';
import { ColorPickComponent } from './color-pick/color-pick.component';
import { ArticleComponent } from './hackernews/article/article.component';
import {FormsModule} from '@angular/forms';
import { LikeComponent } from './hackernews/like/like.component';
import { NavbarComponent } from './hackernews/navbar/navbar.component';
import { FooterComponent } from './hackernews/footer/footer.component';
import { NameCardComponent } from './name-card/name-card.component';
import { NameCardParentComponent } from './name-card-parent/name-card-parent.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    Calculator1Component,
    ColorPickComponent,
    ArticleComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent,
    NameCardComponent,
    NameCardParentComponent,
    ProgressBarComponent,
    RatingBarComponent,
    CountdownTimerComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
