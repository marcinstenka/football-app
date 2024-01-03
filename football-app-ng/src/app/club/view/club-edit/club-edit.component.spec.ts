import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubEditComponent } from './club-edit.component';

describe('ClubEditComponent', () => {
  let component: ClubEditComponent;
  let fixture: ComponentFixture<ClubEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClubEditComponent]
    });
    fixture = TestBed.createComponent(ClubEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
