import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './player/view/player-list/player-list.component';
import { PlayerViewComponent } from './player/view/player-view/player-view.component';
import { PlayerEditComponent } from './player/view/player-edit/player-edit.component';
import { ClubListComponent } from './club/view/club-list/club-list.component';
import { ClubViewComponent } from './club/view/club-view/club-view.component';

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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
