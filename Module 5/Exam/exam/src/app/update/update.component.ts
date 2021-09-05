import { Component, OnInit } from '@angular/core';
import {CaseRecordService} from '../service/CaseRecordService';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CaseRecord} from '../model/CaseRecord';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
  providers: [CaseRecordService]
})
export class UpdateComponent implements OnInit {
  updateForm = new FormGroup(
    {
      id: new FormControl(),
      idCase: new FormControl( null, [Validators.required, Validators.pattern('BA-\\d{4}')]),
      // Validators.pattern('BN-\d{4}')
      idPatient: new FormControl(null,  [Validators.required, Validators.pattern('BN-\\d{4}')]),
      namePatient: new FormControl(null,
        Validators.required),
      hospitalizedDay: new FormControl(null,
        Validators.required),
      hospitalDischargeDate: new FormControl(null,
        Validators.required),
      reason: new FormControl(null,  Validators.required),
      treatments: new FormControl(null,  Validators.required),
      doctor: new FormControl( null, Validators.required)
    }
  );
  editCaseRecord: CaseRecord;
  id: number;
  constructor(
    private caseRecordService: CaseRecordService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap)  => {
      console.log('param' + paramMap.get('id'));
      this.id = Number(paramMap.get('id'));
      console.log(this.id);
      this.caseRecordService.findCaseRecordById(this.id).subscribe(
        (data) => {
          this.editCaseRecord = data;
          console.log(this.editCaseRecord);
          this.updateForm.setValue(data);
        }
      );
    });
  }

  onSubmit(updateForm: FormGroup) {
    this.caseRecordService.updateCaseRecord(updateForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl('');
      }, error => console.log(error)
    );
  }
}
