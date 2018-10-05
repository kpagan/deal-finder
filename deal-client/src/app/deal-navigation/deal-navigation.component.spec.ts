
import { fakeAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { MatSidenavModule } from '@angular/material/sidenav';
import { DealNavigationComponent } from './deal-navigation.component';

describe('DealNavigationComponent', () => {
  let component: DealNavigationComponent;
  let fixture: ComponentFixture<DealNavigationComponent>;

  beforeEach(fakeAsync(() => {
    TestBed.configureTestingModule({
      imports: [MatSidenavModule],
      declarations: [DealNavigationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DealNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});
