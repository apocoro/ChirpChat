import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamYearsComponent } from './team-years.component';

describe('TeamYearsComponent', () => {
  let component: TeamYearsComponent;
  let fixture: ComponentFixture<TeamYearsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TeamYearsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TeamYearsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
