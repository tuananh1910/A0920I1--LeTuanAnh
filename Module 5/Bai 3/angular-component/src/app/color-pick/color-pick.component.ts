import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-pick',
  templateUrl: './color-pick.component.html',
  styleUrls: ['./color-pick.component.css']
})
export class ColorPickComponent implements OnInit {
  backGround = '#00e067';
  changeBackGround(backGround){
    this.backGround = backGround;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
