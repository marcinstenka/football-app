import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './player/view/player-list/player-list.component';
import { PlayerViewComponent } from './player/view/player-view/player-view.component';
import { PlayerEditComponent } from './player/view/player-edit/player-edit.component';
import { ClubListComponent } from './club/view/club-list/club-list.component';
import { ClubViewComponent } from './club/view/club-view/club-view.component';
import { ClubEditComponent } from './club/view/club-edit/club-edit.component';

const routes: Routes = [
  {
    component: PlayerListComponent,
    path: 'players',
  },
  {
    component: PlayerViewComponent,
    path: 'players/:uuid',
  },
  {
    component: PlayerEditComponent,
    path: 'players/:uuid/edit',
  },
  {
    component: ClubListComponent,
    path: 'clubs',
  },
  {
    component: ClubViewComponent,
    path: 'clubs/:uuid',
  },
  {
    component: ClubEditComponent,
    path: 'clubs/:uuid/edit',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
