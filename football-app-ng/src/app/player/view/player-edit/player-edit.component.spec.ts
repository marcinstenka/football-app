import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerEditComponent } from './player-edit.component';

describe('PlayerEditComponent', () => {
  let component: PlayerEditComponent;
  let fixture: ComponentFixture<PlayerEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlayerEditComponent]
    });
    fixture = TestBed.createComponent(PlayerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
