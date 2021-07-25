import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-overview',
  templateUrl: './angular-overview.component.html',
  styleUrls: ['./angular-overview.component.css']
})

export class AngularOverviewComponent implements OnInit {
  fontSize = 14;
  onChange(value: any) {
    this.fontSize = value;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
