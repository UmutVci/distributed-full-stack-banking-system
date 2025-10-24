import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit {
  user: any = null;
  error = '';

  constructor(private http: HttpClient, private router: Router, private authService: AuthService) {}

  ngOnInit() {
    this.http.get('http://localhost:8080/api/v1/me').subscribe({
      next: (data) => (this.user = data),
      error: (err) => {
        console.error(err);
        this.error = 'Failed to load user info';
      },
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
