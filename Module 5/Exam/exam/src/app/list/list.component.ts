import { Component, OnInit } from '@angular/core';
import {CaseRecord} from '../model/CaseRecord';
import {CaseRecordService} from '../service/CaseRecordService';
import {MatDialog} from '@angular/material/dialog';
import {DeleteComponent} from '../delete/delete.component';
import {PatientService} from '../service/PatientService';
import {Patient} from '../model/Patient';
import {dashCaseToCamelCase} from '@angular/compiler/src/util';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [CaseRecordService, PatientService]
})
export class ListComponent implements OnInit {
  constructor(
    private caseRecordService: CaseRecordService,
    private patientService: PatientService,
    private dialog: MatDialog
  ) { }
  caseRecords: CaseRecord[];
  patients: Patient[];

  page = 1;
  idCase: string;

  ngOnInit(): void {
    this.patientService.getPatient().subscribe(
      (data) => {
        this.patients = data;
      }, error => console.log(error)
    );
    this.caseRecordService.getCaseRecord().subscribe(
      (data) => {
        this.caseRecords = data;
      }, error => console.log(error)
    );
  }
  openDialogDelete(id: any) {
    this.caseRecordService.findCaseRecordById(id).subscribe(
      (data) => {
        const dialogRef = this.dialog.open(DeleteComponent,
          {
            data: {
              data,
              id
            },
            width: '400px'
          }
        );
        dialogRef.afterClosed().subscribe(result => {
          console.log(`Dialog result: ${result}`);
          this.ngOnInit();
        });
      }
    );
  }
}
