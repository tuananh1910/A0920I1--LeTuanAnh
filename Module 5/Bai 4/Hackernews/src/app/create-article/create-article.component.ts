import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Article} from '../model/article';
import {ArticleService} from '../service/articleService';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css'],
  providers: [ArticleService]
})
export class CreateArticleComponent implements OnInit {

  @Output() addArticleOutput = new EventEmitter<any>();
  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
  }

  onSubmit(createArticle: NgForm) {
    this.articleService.createAritcle(createArticle.value);
  }
}
