import { Component } from '@angular/core';
import { Team } from '../../common/team';
import { TeamService } from '../../services/team.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrl: './team-details.component.css'
})
export class TeamDetailsComponent {
  teams: Team[] = [];
  franchiseId: number = 1;
  year = 200020001

  constructor(private teamService: TeamService,
    private route: ActivatedRoute) { }

    ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listDetails();
      });

    

}
listDetails() {
  const hasFranchiseId: boolean = this.route.snapshot.paramMap.has("franchiseId");
  const hasYear: boolean = this.route.snapshot.paramMap.has("year");

  if (hasFranchiseId && hasYear) {
    this.franchiseId = +this.route.snapshot.paramMap.get("franchiseId")!;
    this.year = +this.route.snapshot.paramMap.get("year")!;
  } else {
    this.franchiseId = 1
    this.year = 20002001
  }
  this.teamService.getTeamDetails(this.franchiseId,this.year).subscribe(
    data => {
      this.teams = data;
    }
  )
}
}
