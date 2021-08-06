import {Observable} from 'rxjs';
import {TypeCustomer} from '../model/TypeCustomer';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TypeCustomerService {
  private readonly API_URL = 'http://localhost:3000/typeCustomers';
  constructor(private httpClient: HttpClient) {
  }
  public getTypeCustomer(): Observable<TypeCustomer[]>{
    return this.httpClient.get<TypeCustomer[]>(this.API_URL);
  }
}
