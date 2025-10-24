import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

interface LoginResponse {
  token: string;
  message?: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/v1/auth'; // Gateway URL
  private tokenKey = 'token';

  constructor(private http: HttpClient) {}

  login(ownerEmail: string, password: string): Observable<LoginResponse> {
    return this.http
      .post<LoginResponse>(`${this.apiUrl}/login`, { ownerEmail, password })
      .pipe(
        tap((res) => {
          if (res && res.token) {
            localStorage.setItem(this.tokenKey, res.token);
          }
        })
      );
  }

  register(
    email: string,
    password: string,
    name: string,
    accountType: string
  ): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, {
      email,
      password,
      name,
      accountType,
    });
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  logout(): void {
    localStorage.removeItem(this.tokenKey);
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    return !!token;
  }
}
