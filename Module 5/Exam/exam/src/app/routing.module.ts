import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from '@angular/router';
import {ListComponent} from './list/list.component';
import {UpdateComponent} from './update/update.component';
import {CreateComponent} from './create/create.component';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: '', pathMatch: 'full', component: ListComponent
      },
      {
        path: 'update-CaseRecord/:id', component: UpdateComponent
      },
      {
        path: 'add-CaseRecord', component: CreateComponent
      },
    ])
  ]
})
export class RoutingModule { }
