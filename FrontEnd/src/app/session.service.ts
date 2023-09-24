import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() { }
  private readonly CUSTOMER_ID_KEY = 'customer_id';
  
  getCustomerId(): string | null {
    return sessionStorage.getItem(this.CUSTOMER_ID_KEY);
  }

  setCustomerId(customerId: string): void {
    sessionStorage.setItem(this.CUSTOMER_ID_KEY, customerId);
  }

  clearSession(): void {
    sessionStorage.clear();
  }
}
