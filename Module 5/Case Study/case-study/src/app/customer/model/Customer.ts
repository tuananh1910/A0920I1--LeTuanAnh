import {TypeCustomer} from './TypeCustomer';

export class Customer {
  id: number;
  typeCustomer: TypeCustomer;
  name: string;
  birthDate: string;
  idCard: string;
  phone: string;
  email: string;
  address: string;
  constructor(id: number, typeCustomer: TypeCustomer, name: string, birthDate: string,
              idCard: string, phone: string, email: string, address: string) {
    this.id = id;
    this.typeCustomer = typeCustomer;
    this.birthDate = birthDate;
    this.idCard = idCard;
    this.phone = phone;
    this.email = email;
    this.address = address;
  }
}
