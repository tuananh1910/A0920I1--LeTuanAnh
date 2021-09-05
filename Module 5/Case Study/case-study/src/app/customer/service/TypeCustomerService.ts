import {Observable} from 'rxjs';
import {CustomerType} from '../model/CustomerType';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TypeCustomerService {
  private readonly API_URL = 'http://localhost:3000/typeCustomers';
  constructor(private httpClient: HttpClient) {
  }
  public getTypeCustomer(): Observable<CustomerType[]>{
    return this.httpClient.get<CustomerType[]>(this.API_URL);
  }
}
