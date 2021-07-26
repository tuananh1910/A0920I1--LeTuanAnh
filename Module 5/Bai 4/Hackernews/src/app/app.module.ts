import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleComponent } from './article/list-article/article.component';
import {FormsModule} from '@angular/forms';
import { UpdateArticleComponent } from './article/update-article/update-article.component';
import {CreateArticleComponent} from './create-article/create-article.component';
import {LikesComponent} from './likes/likes.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    UpdateArticleComponent,
    CreateArticleComponent,
    LikesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
