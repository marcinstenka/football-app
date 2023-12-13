import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './player/view/player-list/player-list.component';
import { PlayerViewComponent } from './player/view/player-view/player-view.component';
import { PlayerEditComponent } from './player/view/player-edit/player-edit.component';

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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
