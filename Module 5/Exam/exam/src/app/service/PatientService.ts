import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CaseRecord} from '../model/CaseRecord';
import {Inject, Injectable} from '@angular/core';
import {isElementScrolledOutsideView} from '@angular/cdk/overlay/position/scroll-clip';
import {Patient} from '../model/Patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private readonly API_URL = 'http://localhost:3000/patients';
  constructor(private httpClient: HttpClient) {
  }
  public getPatient(): Observable<Patient[]>{
    return this.httpClient.get<Patient[]>(this.API_URL);
  }
  // public addCaseRecord(caseRecord: CaseRecord): Observable<void>{
  //   return this.httpClient.post<void>(this.API_URL, caseRecord);
  // }
  // public findCaseRecordById(id: number): Observable<CaseRecord>{
  //   return this.httpClient.get<CaseRecord>(this.API_URL + '/' + (id));
  // }
  // public updateCaseRecord(updateCaseRecord: CaseRecord): Observable<void>{
  //   return this.httpClient.put<void>(this.API_URL + '/' + updateCaseRecord.id, updateCaseRecord);
  // }
  // public deleteCaseRecord(id){
  //   console.log(id);
  //   console.log(this.API_URL + '/' + id);
  //   return this.httpClient.delete(this.API_URL + '/' + id);
  // }
  // public searchCustomer(searchKey: string): Observable<CaseRecord[]>{
  //     console.log(this.API_URL + '?name=' + searchKey);
  //     return this.httpClient.get<CaseRecord[]>(this.API_URL + '?name=' + searchKey);
  //   }
}
