import {Component, Inject, OnInit} from '@angular/core';
import {ArticleService} from '../service/articleService';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {isElementScrolledOutsideView} from '@angular/cdk/overlay/position/scroll-clip';

@Component({
  selector: 'app-delete-article',
  templateUrl: './delete-article.component.html',
  styleUrls: ['./delete-article.component.css'],
  providers: [ArticleService]

})
export class DeleteArticleComponent implements OnInit {
  id: any;
  constructor(private articleService: ArticleService,
              @Inject(MAT_DIALOG_DATA) public data: any) {
    console.log(data.id);
    this.id = data.id;
  }
  ngOnInit(): void {
  }
  onSubmit(id: any){
    console.log('idDelete :' + id);
    this.articleService.deleteArticle(id);
  }

}
