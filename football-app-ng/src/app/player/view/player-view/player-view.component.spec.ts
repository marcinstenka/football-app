import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerViewComponent } from './player-view.component';

describe('PlayerViewComponent', () => {
  let component: PlayerViewComponent;
  let fixture: ComponentFixture<PlayerViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlayerViewComponent]
    });
    fixture = TestBed.createComponent(PlayerViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
