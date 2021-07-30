import {articles} from '../repository/ArticleRepository';
import {Article} from '../model/article';
import {NgForm} from '@angular/forms';
import {formatNumber} from '@angular/common';
import {compilePipeFromMetadata} from '@angular/compiler';

export class ArticleService {
  article: Article;
  startIndex: any;
  endIndex: any;
  public getArticles(){
    return articles;
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
