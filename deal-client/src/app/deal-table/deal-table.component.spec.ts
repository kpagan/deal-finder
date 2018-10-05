
import { fakeAsync, ComponentFixture, TestBed } from '@angular/core/testing';

import { DealTableComponent } from './deal-table.component';

describe('DealTableComponent', () => {
  let component: DealTableComponent;
  let fixture: ComponentFixture<DealTableComponent>;

  beforeEach(fakeAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DealTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DealTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});
