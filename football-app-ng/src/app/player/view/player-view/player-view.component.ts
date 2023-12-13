import { Component, OnInit } from '@angular/core';
import { PlayerDetails } from '../../model/player-details';
import { PlayerService } from '../../service/player.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css'],
})
export class PlayerViewComponent implements OnInit {
  player: PlayerDetails | undefined;

  constructor(
    private service: PlayerService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.service
        .getPlayer(params['uuid'])
        .subscribe((player) => (this.player = player));
    });
  }
}
