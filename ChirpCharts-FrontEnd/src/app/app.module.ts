import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeamListComponent } from './component/team-list/team-list.component';
import { HttpClientModule } from '@angular/common/http';
import { TeamService } from './services/team.service';
import { TeamYearsComponent } from './component/team-years/team-years.component';
import { Routes } from '@angular/router';
import { TeamDetailsComponent } from './component/team-details/team-details.component';
import { FormsModule } from '@angular/forms';


const routes: Routes = [
  {path: 'team', component: TeamListComponent },
  {path: 'team/:franchiseId', component: TeamListComponent },
  {path: '', redirectTo: 'team', pathMatch: 'full' },
  {path: '**', redirectTo: 'team', pathMatch: 'full' }
  
];
@NgModule({
  declarations: [
    AppComponent,
    TeamListComponent,
    TeamYearsComponent,
    TeamDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TeamService],
  bootstrap: [AppComponent]
})
export class AppModule { }
