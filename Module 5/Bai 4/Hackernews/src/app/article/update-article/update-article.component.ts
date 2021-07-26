import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Article} from '../../model/article';
import {NgForm} from '@angular/forms';
import {ArticleService} from '../../service/articleService';
import {articles} from '../../repository/ArticleRepository';

@Component({
  selector: 'app-update-article',
  templateUrl: './update-article.component.html',
  styleUrls: ['./update-article.component.css']
})
export class UpdateArticleComponent implements OnInit {
  // @Output() sendArticle = new EventEmitter();
  articles: Article[] = articles;
  article: Article;
  id: any;
  constructor(
    private activatedRoute: ActivatedRoute
    // private articleService: ArticleService
  ) { }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap)  => {
      console.log('param' + paramMap.get('id'));
    });
  }
}
