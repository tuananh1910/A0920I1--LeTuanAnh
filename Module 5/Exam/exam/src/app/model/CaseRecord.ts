
export class CaseRecord {
  id: string;
  idPatient: string;
  namePatient: string;
  hospitalizedDay: string;
  hospitalDischargeDate: string;
  reason: string;
  treatments: string;
  doctor: string;
  constructor(id: string, idPatient: string, namePatient: string, hospitalizedDay: string,
              hospitalDischargeDate: string, reason: string, treatments: string, doctor: string) {
    this.idPatient = idPatient;
    this.namePatient = namePatient;
    this.hospitalizedDay = hospitalizedDay;
    this.hospitalDischargeDate = hospitalDischargeDate;
    this.reason = reason;
    this.treatments = treatments;
    this.doctor = doctor;
    this.id = id;
  }
}
