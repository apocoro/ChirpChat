import { Component, OnInit } from '@angular/core';
import { TeamService } from '../../services/team.service';
import { Team } from '../../common/team';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list-table.component.html',
  styleUrl: './team-list.component.css'
})
export class TeamListComponent implements OnInit {

  teams: Team[] = [];
  teamsSearch: Team[] = [];
  searchField: string = '';

  constructor(private teamService: TeamService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.searchField = params['search'] || '';
      this.listTeams();
      });
  }
/*
  listTeams() {
    // check if "id" paramter is available
    const hasTeamId: boolean = this.route.snapshot.paramMap.has("id");

    if (hasTeamId) {
      this.currentTeamId = +this.route.snapshot.paramMap.get("id")!;
    } else {
      // not Team id available - default to 1
      this.currentTeamId = 1;
    }

    // now get teams for the given id
    this.teamService.getTeamList(this.currentTeamId).subscribe(
      data => {
        this.teams = data;
      }
    )
  } */

  listTeams() {
    console.log('Search query:', this.searchField); // DEBUG

    // now get teams for the given id
    this.teamService.getTeamList().subscribe(
      data => {
        this.teams = data;

        if (this.searchField) {
          this.teamsSearch = this.teams.filter(team => 
            team.teamName.toLowerCase().includes(this.searchField.toLowerCase())
          ).sort((a, b) => a.teamName.localeCompare(b.teamName));
        } else {
          this.teamsSearch = this.teams 
          .sort((a, b) => a.teamName.localeCompare(b.teamName));
        }
  }
);

}
}
