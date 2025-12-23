import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Team } from '../common/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private baseUrl = "https://back-end-java-springboot-chirpcharts-production.up.railway.app/api/teams";



  constructor(private httpClient: HttpClient) { }

    

  /*getTeamList(theFranchiseId: number): Observable<Team[]> {

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theFranchiseId}`

    //swtich our searchUrl with base Url to get the teams id

    return this.httpClient.get<GetResponse>(`${this.baseUrl}/team-list`).pipe(
      map(response => response._embedded.teams)
    );
  } */


getTeamList(): Observable<Team[]> {
  return this.httpClient.get<Team[]>(`${this.baseUrl}/team-list`);
}


getTeamYearsList(theFranchiseId: number): Observable<Team[]> {

    const searchUrl = `${this.baseUrl}/team-years?franchiseId=${theFranchiseId}`;

    return this.httpClient.get<Team[]>(searchUrl);
}

getTeamDetails(theFranchiseId: number, theYear: number): Observable<Team[]> {
const searchUrl = `${this.baseUrl}/team-details?franchiseId=${theFranchiseId}&year=${theYear}`;

    return this.httpClient.get<Team[]>(searchUrl);

}


}


//not used but maybe in the future
interface GetResponse {
  _embedded: {
    teams: Team[];
  }
}

