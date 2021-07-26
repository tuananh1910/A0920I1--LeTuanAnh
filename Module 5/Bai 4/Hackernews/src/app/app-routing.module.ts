import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UpdateArticleComponent} from './article/update-article/update-article.component';
import {ArticleComponent} from './article/list-article/article.component';
import {CreateArticleComponent} from './create-article/create-article.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', component: ArticleComponent},
  {path: 'update-article/:id', component: UpdateArticleComponent},
  {path: 'create-article', component: CreateArticleComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
