import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Article} from '../../model/article';
import {articles} from '../../repository/ArticleRepository';
import {MatDialog} from '@angular/material/dialog';
import {DeleteArticleComponent} from '../../delete-article/delete-article.component';
@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
})

export class ArticleComponent implements OnInit {
  articles: Article[] = articles;
  article: Article;
  constructor(
    public dialog: MatDialog
  ) {
  }
  ngOnInit(): void {
    this.articles = articles;
  }
  openDialogDelete(id: any) {
    const dialogRef = this.dialog.open(DeleteArticleComponent,
    {data: {
          id
      }});


    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }


  // article: Article;

}
