import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubViewComponent } from './club-view.component';

describe('ClubViewComponent', () => {
  let component: ClubViewComponent;
  let fixture: ComponentFixture<ClubViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClubViewComponent]
    });
    fixture = TestBed.createComponent(ClubViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
