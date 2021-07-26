import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Article} from '../../model/article';
import {articles} from '../../repository/ArticleRepository';
@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
})

export class ArticleComponent implements OnInit {
  constructor() {
  }
  articles: Article[] = articles;
  article: Article;
  saveArticle(article: Article){
    console.log('nhan data tu createComp');
    this.articles.push(article);
  }
  ngOnInit(): void {
  }
// sủ dụng service để lấy list article
  // articles: Article[];

  // constructor(private articleService: ArticleService) {
  // }
  // getArticles(){
  //   this.articles = this.articleService.getArticles();
  // }

  // updateArticle(art: Article) {
  // }
}
