import { Component, OnInit } from '@angular/core';
import {CaseRecordService} from '../service/CaseRecordService';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
  providers: [CaseRecordService]
})
export class CreateComponent implements OnInit {
  createForm: FormGroup;

  constructor(
    private caseRecordService: CaseRecordService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.createForm = new FormGroup({
      idCase: new FormControl(null, [Validators.required,
      Validators.pattern('BA-\\d{4}')]),
      idPatient: new FormControl(null, [Validators.required, Validators.pattern('BN-\\d{4}')]),
      namePatient: new FormControl(
        null, [Validators.required, Validators.pattern('^[a-zA-Z\+]*$')]),
      hospitalizedDay: new FormControl(
        null, Validators.required),
      hospitalDischargeDate: new FormControl(
        null, Validators.required),
      reason: new FormControl(null, Validators.required),
      treatments: new FormControl(null, Validators.required),
      doctor: new FormControl(null, Validators.required)
    });
  }

  onSubmit(createForm: FormGroup) {
    this.caseRecordService.addCaseRecord(createForm.value).subscribe(
      (data) => {
this.router.navigateByUrl('');
      }, error => console.log(error)
    );
  }
}
