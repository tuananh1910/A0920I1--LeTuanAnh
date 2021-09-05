import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ListComponent} from './customer/list/list.component';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {CustomerService} from './customer/service/CustomerService';
import {CreateComponent} from './customer/create/create.component';
import {UpdateComponent} from './customer/update/update.component';
import {DeleteComponent} from './customer/delete/delete.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TypeCustomerService} from './customer/service/TypeCustomerService';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {NgxPaginationModule} from 'ngx-pagination';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';
import {CategoryService, ChartModule, LineSeriesService} from '@syncfusion/ej2-angular-charts';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    CreateComponent,
    UpdateComponent,
    DeleteComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: '', pathMatch: 'full', component: ListComponent},
      {
        path: 'add-Customer', component: CreateComponent
      },
      {
        path: 'update-Customer/:id', component: UpdateComponent
      },
    ]),
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatButtonModule,
    NgxPaginationModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatPaginatorModule,
    MatTableModule,
    MatSelectModule,
    ChartModule
  ],
  providers: [
    CustomerService,
    TypeCustomerService,
    LineSeriesService,
    CategoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
