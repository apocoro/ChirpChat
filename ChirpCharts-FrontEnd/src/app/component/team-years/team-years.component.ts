import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Team } from '../../common/team';
import { TeamService } from '../../services/team.service';

@Component({
  selector: 'app-team-years',
  templateUrl: './team-years.component.html',
  styleUrl: './team-years.component.css'
})
export class TeamYearsComponent implements OnInit {
  teams: Team[] = [];
  franchiseId: number = 1;

    constructor(private teamService: TeamService,
      private route: ActivatedRoute) { }

ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listYears();
      });

}
  listYears() {
    // check if "id" paramter is available
    const hasFranchiseId: boolean = this.route.snapshot.paramMap.has("franchiseId");

    if (hasFranchiseId) {
      this.franchiseId = +this.route.snapshot.paramMap.get("franchiseId")!;
    } else {
      // not Team id available - default to 1
      this.franchiseId = 1;
    }

    // now get teams for the given id
    this.teamService.getTeamYearsList(this.franchiseId).subscribe(
      data => {
        this.teams = data;
      }
    )
  }

}
