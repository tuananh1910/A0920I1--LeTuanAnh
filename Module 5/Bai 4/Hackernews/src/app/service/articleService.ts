import {articles} from '../repository/ArticleRepository';
import {Article} from '../model/article';
import {NgForm} from '@angular/forms';

export class ArticleService {
  article: Article;
  public getArticles(){
    return articles;
  }
  public updateArticle(updateArticle: Article){
  }
  public createAritcle(createArticle: Article){
    articles.push(createArticle);
  }
}
