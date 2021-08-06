import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from '@angular/router';
import {ListComponent} from './customer/list/list.component';
import {CreateComponent} from './customer/create/create.component';
import {UpdateComponent} from './customer/update/update.component';



@NgModule({
  declarations: [],
  imports:  [
    CommonModule,
    RouterModule.forRoot([
      {
        path: '', pathMatch: 'full', component: ListComponent
      },
      {
        path: 'update-Customer/:id', component: UpdateComponent
      },
      {
        path: 'add-Customer', component: CreateComponent
      },
    ])
  ],
  exports: [RouterModule]
})
export class RoutingModule { }
