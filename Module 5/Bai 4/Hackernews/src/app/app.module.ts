import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleComponent } from './article/list-article/article.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { UpdateArticleComponent } from './article/update-article/update-article.component';
import {CreateArticleComponent} from './create-article/create-article.component';
import {LikesComponent} from './likes/likes.component';
import {DeleteArticleComponent} from './delete-article/delete-article.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    UpdateArticleComponent,
    CreateArticleComponent,
    LikesComponent,
    DeleteArticleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatDialogModule,
    MatButtonModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
