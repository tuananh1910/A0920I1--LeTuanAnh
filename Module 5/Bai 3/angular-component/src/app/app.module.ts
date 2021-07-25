import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularOverviewComponent } from './angular-overview/angular-overview.component';
import { PetComponent } from './pet/pet.component';
import { CalculatorComponent } from './calculator/calculator.component';
import {FormsModule} from '@angular/forms';
import { ColorPickComponent } from './color-pick/color-pick.component';

@NgModule({
  declarations: [
    AppComponent,
    AngularOverviewComponent,
    PetComponent,
    CalculatorComponent,
    ColorPickComponent
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
