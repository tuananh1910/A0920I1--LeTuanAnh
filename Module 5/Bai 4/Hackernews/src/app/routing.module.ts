import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UpdateArticleComponent} from './article/update-article/update-article.component';
import {CreateArticleComponent} from './create-article/create-article.component';

// const routes: Routes[
//   {path: '', pathMatch: 'full', redirectTo: 'list-article'},
//   {path:'update-article/:id', component: UpdateArticleComponent};
//   ]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: '', pathMatch: 'full', redirectTo: 'list-article'
      },
      {
        path: 'update-article/:id', component: UpdateArticleComponent
      },
      {path: 'create-article', component: CreateArticleComponent}

    ])
  ]
})
export class RoutingModule { }
