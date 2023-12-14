import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavComponent } from './components/nav/nav.component';
import { MainComponent } from './components/main/main.component';
import { PlayerViewComponent } from './player/view/player-view/player-view.component';
import { PlayerListComponent } from './player/view/player-list/player-list.component';
import { PlayerEditComponent } from './player/view/player-edit/player-edit.component';
import { PlayerService } from './player/service/player.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ClubListComponent } from './club/view/club-list/club-list.component';
import { ClubViewComponent } from './club/view/club-view/club-view.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavComponent,
    MainComponent,
    PlayerViewComponent,
    PlayerListComponent,
    PlayerEditComponent,
    ClubListComponent,
    ClubViewComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [PlayerService],
  bootstrap: [AppComponent],
})
export class AppModule {}
