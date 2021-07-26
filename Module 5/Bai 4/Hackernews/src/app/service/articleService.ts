import {articles} from '../repository/ArticleRepository';
import {Article} from '../model/article';

export class ArticleService {
  article: Article;
  public getArticles(){
    return articles;
  }
  public updateArticle(id: string){
    // this.article = articles.;
  }
}
