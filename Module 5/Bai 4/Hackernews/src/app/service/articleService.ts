import {Article} from '../model/article';

export class ArticleService {
  public getArticles(){
    let articles: Article[];
    articles = [
      new Article('Game of Life', 'https://thefullsnack.com/posts/game-of-life.html'),
      new Article('Nguyên tắc thiết kế REST API', 'https://medium.com/eway/nguyên-tắc-thiết-kế-rest-api-23add16968d7')
    ];
    return articles;
  }
}
