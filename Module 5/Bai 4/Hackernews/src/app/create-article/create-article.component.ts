import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Article} from '../model/article';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {
  // @Input() article: Article;

  @Output() addArticleOutput = new EventEmitter<any>();
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(createArticle: NgForm) {
    console.log(createArticle.value);
    this.addArticleOutput.emit(createArticle.value);
  }
}
