import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Article} from '../../model/article';
import {FormControl, FormGroup, NgForm} from '@angular/forms';
import {ArticleService} from '../../service/articleService';
import {articles} from '../../repository/ArticleRepository';
import {FocusMonitor} from '@angular/cdk/a11y';

@Component({
  selector: 'app-update-article',
  templateUrl: './update-article.component.html',
  styleUrls: ['./update-article.component.css'],
  providers: [ArticleService]

})
export class UpdateArticleComponent implements OnInit {
  // @Output() sendArticle = new EventEmitter();
  updateFormArticle: FormGroup;
  article: Article;
  id: any;
  constructor(
    private activatedRoute: ActivatedRoute,
    private articleService: ArticleService
  ) { }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap)  => {
      console.log('param' + paramMap.get('id'));
      this.id = paramMap.get('id');
    });
    this.article = articles.find(article => article.id = this.id);
    this.updateFormArticle = new FormGroup({
      id : new FormControl(this.id),
      title : new FormControl(this.article.title),
      url : new FormControl(this.article.url)
    });
  }
  onSubmit(updateArticle: FormGroup){
    console.log(updateArticle.value);
    this.articleService.updateArticle(updateArticle.value);
  }
}
