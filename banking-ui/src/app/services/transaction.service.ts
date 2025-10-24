import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class TransactionService {
  private apiUrl = 'http://localhost:8080/api/v1/transactions';

  constructor(private http: HttpClient) {}

  transfer(fromAccountId: string, toAccountId: string, amount: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/transfer`, {
      from_account_id: fromAccountId,
      to_account_id: toAccountId,
      amount: amount,
    });
  }
}
