import {CustomerType} from './CustomerType';

export class Customer {
  id: string;
  customerType: CustomerType;
  name: string;
  birthday: string;
  idCard: string;
  phone: string;
  gender: string;
  email: string;
  address: string;
  constructor(id: string, typeCustomer: CustomerType, name: string, birthDate: string,
              idCard: string, phone: string, gender: string, email: string, address: string) {
    this.id = id;
    this.customerType = typeCustomer;
    this.birthday = birthDate;
    this.idCard = idCard;
    this.phone = phone;
    this.gender = gender;
    this.email = email;
    this.address = address;
  }
}
