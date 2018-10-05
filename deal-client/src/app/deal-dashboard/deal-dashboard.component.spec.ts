
import { fakeAsync, ComponentFixture, TestBed } from '@angular/core/testing';

import { DealDashboardComponent } from './deal-dashboard.component';

describe('DealDashboardComponent', () => {
  let component: DealDashboardComponent;
  let fixture: ComponentFixture<DealDashboardComponent>;

  beforeEach(fakeAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DealDashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DealDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});
