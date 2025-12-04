import { Component, OnInit } from '@angular/core';
import { TeamService } from '../../services/team.service';
import { Team } from '../../common/team';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list-table.component.html',
  styleUrl: './team-list.component.css'
})
export class TeamListComponent implements OnInit {

  teams: Team[] = [];
  constructor(private teamService: TeamService) {}

  ngOnInit(): void {
      this.listTeams();
  }

  listTeams() {
    this.teamService.getTeamList().subscribe(
      data => {
        this.teams = data;
      }
    )
  }

}
