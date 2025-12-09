import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeamListComponent } from './component/team-list/team-list.component';
import { HttpClientModule } from '@angular/common/http';
import { TeamService } from './services/team.service';
import { TeamYearsComponent } from './component/team-years/team-years.component';
import { Routes } from '@angular/router';


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
    TeamYearsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [TeamService],
  bootstrap: [AppComponent]
})
export class AppModule { }
