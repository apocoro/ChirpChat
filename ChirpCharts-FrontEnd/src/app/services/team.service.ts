import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Team } from '../common/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private baseUrl = "http://localhost:8080/api/teams"

  constructor(private httpClient: HttpClient) { }

    

  getTeamList(theFranchiseId: number): Observable<Team[]> {

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theFranchiseId}`

    //swtich our searchUrl with base Url to get the teams id

    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.teams)
    );
  }
}
interface GetResponse {
  _embedded: {
    teams: Team[];
  }
}

