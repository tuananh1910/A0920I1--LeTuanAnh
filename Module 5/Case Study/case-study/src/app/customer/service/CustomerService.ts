import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/Customer';
import {Inject, Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private readonly API_URL = 'http://localhost:3000/customers';
  constructor(private httpClient: HttpClient) {
  }
  public getCustomer(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.API_URL);
  }
  public addCustomer(customer: Customer): Observable<void>{
    return this.httpClient.post<void>(this.API_URL, customer);
  }
  public findCustomerById(id: number): Observable<Customer>{
    return this.httpClient.get<Customer>(this.API_URL + '/' + (id));
  }
  public updateCustomer(updateCustomer: Customer): Observable<void>{
    return this.httpClient.put<void>(this.API_URL + '/' + updateCustomer.id, updateCustomer);
  }
  public deleteCustomer(id){
    console.log(id);
    console.log(this.API_URL + '/' + id);
    return this.httpClient.delete(this.API_URL + '/' + id);
  }
}
