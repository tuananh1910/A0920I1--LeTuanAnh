import {Component, Inject, OnInit} from '@angular/core';
import {CaseRecordService} from '../service/CaseRecordService';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  obj: any;
  id: number;
  constructor(
    private caseRecordService: CaseRecordService,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.obj = data.data;
    this.id = data.id;
  }

  ngOnInit(): void {
  }

  onSubmit(id: any) {
    console.log(id);
    this.caseRecordService.deleteCaseRecord(id).subscribe(
      (data) => {
      }, error => console.log(error)
    );
  }
}
