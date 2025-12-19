import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ChirpCharts-FrontEnd';
  searchTerm: string = '';

  constructor(private router: Router) {}

  onSearch() {
    const query = this.searchTerm.trim();
    if (query) {
      this.router.navigate(['/team-list'], { queryParams: { search: query} });
      this.searchTerm = '';
    }
  }
}
