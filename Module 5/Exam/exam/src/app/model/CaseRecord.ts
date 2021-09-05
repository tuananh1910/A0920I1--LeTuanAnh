import {Patient} from './Patient';

export class CaseRecord {
  id: string;
  idCase: string;
  idPatient: string;
  namePatient: string;
  // patient: Patient;
  hospitalizedDay: string;
  hospitalDischargeDate: string;
  reason: string;
  treatments: string;
  doctor: string;
  constructor(id: string, idCase: string, idPatient: string, namePatient: string, hospitalizedDay: string,
              hospitalDischargeDate: string, reason: string, treatments: string, doctor: string) {
    this.idPatient = idPatient;
    this.namePatient = namePatient;
    this.hospitalizedDay = hospitalizedDay;
    this.hospitalDischargeDate = hospitalDischargeDate;
    this.reason = reason;
    this.treatments = treatments;
    this.doctor = doctor;
    this.idCase = idCase;
    this.id = id;
  }
  // tslint:disable-next-line:max-line-length
  // constructor(id: string, idCase: string, patient: Patient, hospitalizedDay: string, hospitalDischargeDate: string, reason: string, treatments: string, doctor: string) {
  //   this.id = id;
  //   this.idCase = idCase;
  //   this.patient = patient;
  //   this.hospitalizedDay = hospitalizedDay;
  //   this.hospitalDischargeDate = hospitalDischargeDate;
  //   this.reason = reason;
  //   this.treatments = treatments;
  //   this.doctor = doctor;
  // }
}
