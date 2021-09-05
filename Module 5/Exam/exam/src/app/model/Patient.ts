export class Patient {
  id: string;
  idPatient: string;
  namePatient: string;


  constructor(id: string, idPatient: string, namePatient: string) {
    this.id = id;
    this.idPatient = idPatient;
    this.namePatient = namePatient;
  }
}
