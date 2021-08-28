import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CaseRecord} from '../model/CaseRecord';
import {Inject, Injectable} from '@angular/core';
import {isElementScrolledOutsideView} from '@angular/cdk/overlay/position/scroll-clip';

@Injectable({
  providedIn: 'root'
})
export class CaseRecordService {
  private readonly API_URL = 'http://localhost:3000/patients';
  constructor(private httpClient: HttpClient) {
  }
  public getCustomer(): Observable<CaseRecord[]>{
    return this.httpClient.get<CaseRecord[]>(this.API_URL);
  }
  // public addCustomer(customer: CaseRecord): Observable<void>{
  //   return this.httpClient.post<void>(this.API_URL, customer);
  // }
  // public findCustomerById(id: number): Observable<CaseRecord>{
  //   return this.httpClient.get<CaseRecord>(this.API_URL + '/' + (id));
  // }
  // public updateCustomer(updateCustomer: CaseRecord): Observable<void>{
  //   return this.httpClient.put<void>(this.API_URL + '/' + updateCustomer.id, updateCustomer);
  // }
  // public deleteCustomer(id){
  //   console.log(id);
  //   console.log(this.API_URL + '/' + id);
  //   return this.httpClient.delete(this.API_URL + '/' + id);
  // }
  // public searchCustomer(searchKey: string): Observable<CaseRecord[]>{
  //     console.log(this.API_URL + '?name=' + searchKey);
  //     return this.httpClient.get<CaseRecord[]>(this.API_URL + '?name=' + searchKey);
  //   }
}
