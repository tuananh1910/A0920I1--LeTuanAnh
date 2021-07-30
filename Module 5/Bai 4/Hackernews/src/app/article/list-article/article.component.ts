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
  // article: Article;
  ngOnInit(): void {
    this.articles = articles;
  }
}
