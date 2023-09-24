
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, pipe, throwError } from 'rxjs';
 import { SessionService } from './session.service';
 import{catchError} from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private baseUrl = 'http://localhost:8080/customer';
  private billurl = 'http://localhost:8080/monthlybill';
  private debiturl ='http://localhost:8080/debitcard' ;
  private crediturl ='http://localhost:8080/creditcard';
  private walleturl = 'http://localhost:8080/wallet';
  private transaction='http://localhost:8080/transaction';

  constructor(private http: HttpClient) { }

  getlogin(customerId:any):Observable<any>{
    return this.http.get<any>(`${this.baseUrl}/login/${customerId}`);
  }
  getBillsByCustomerId(customerId: number): Observable<any[]> {
    const url = `${this.billurl}/bills/${customerId}`;
    return this.http.get<any[]>(url);
  }
  getPaidBills(customerId: number): Observable<any[]>{
    const url = `${this.billurl}/paidbills/${customerId}`;
    return this.http.get<any[]>(url);
  }
  checkcredit(acc: string, cvv: number,id: number, month: number, year: number): Observable<any> {
    const url = `${this.crediturl}/checkcredit/${id}?acc=${acc}&cvv=${cvv}&month=${month}&year=${year}`;

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }
    
  return this.http.post<any>(url, {httpOptions})
  .pipe(catchError(error => {
    return throwError(error.error);
  }))
}
checkdebit( acc: string, cvv: number,id: number, month: number, year: number): Observable<any>{
  const url1 = `${this.debiturl}/checkdebit/${id}?acc=${acc}&cvv=${cvv}&month=${month}&year=${year}`;

  const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

    return this.http.post<any>(url1, httpOptions)
    .pipe(catchError(error => {
      return throwError(error.error);
    }))
}
checkwallet(id: number, walletId: string, walletName: string): Observable<any>{
  const url = `${this.walleturl}/checkwallet/${id}?walletId=${walletId}&walletName=${walletName}`;
  const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
  return this.http.post<any>(url,httpOptions)
  .pipe(catchError(error => {
    return throwError(error.error);
}))
}

}
