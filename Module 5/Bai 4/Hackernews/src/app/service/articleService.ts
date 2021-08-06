import {articles} from '../repository/ArticleRepository';
import {Article} from '../model/article';
import {NgForm} from '@angular/forms';
import {formatNumber} from '@angular/common';
import {compilePipeFromMetadata} from '@angular/compiler';
import {absoluteFromSourceFile} from '@angular/compiler-cli/src/ngtsc/file_system';

export class ArticleService {
  article: Article;
  startIndex: any;
  endIndex: any;
  public getArticles(){
    return articles;
  }
  public deleteArticle(id: any){
    console.log('Delete Service:' + (id - 1));
    articles.splice((id - 1), 1);
  }
  public updateArticle(updateArticle: Article){
    // this.startIndex = Number(updateArticle.id) ;
    console.log(updateArticle.id);
    this.startIndex = Number(updateArticle.id) - 1;
    this.endIndex = Number(this.startIndex) + 1;
    console.log(this.startIndex);
    console.log(this.endIndex);
    articles.fill(updateArticle, this.startIndex, this.endIndex);
  }
  public createArticle(createArticle: Article){
    articles.push(createArticle);
  }
}
