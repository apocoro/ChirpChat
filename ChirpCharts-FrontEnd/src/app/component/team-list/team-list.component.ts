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
  currentTeamId: number = 1;

  constructor(private teamService: TeamService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {


      this.listTeams();
      });
  }

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
  }

}
