import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeamListComponent } from './component/team-list/team-list.component';
import { TeamYearsComponent } from './component/team-years/team-years.component';
import { TeamDetailsComponent } from './component/team-details/team-details.component';


const routes: Routes = [
  { path: 'team-list', component: TeamListComponent },
  { path: 'team/:franchiseId', component: TeamYearsComponent },
  { path: 'team/:franchiseId/:year', component: TeamDetailsComponent },
  { path: '', redirectTo: 'team-list', pathMatch: 'full' },
  { path: '**', redirectTo: 'team', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
