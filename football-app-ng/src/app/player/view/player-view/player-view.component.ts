import { Component, OnInit } from '@angular/core';
import { PlayerDetails } from '../../model/player-details';
import { PlayerService } from '../../service/player.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ClubService } from 'src/app/club/service/club.service';

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css'],
})
export class PlayerViewComponent implements OnInit {
  player: PlayerDetails | undefined;
  clubName: string = '';
  clubId: string = '';
  constructor(
    private service: PlayerService,
    private clubSerivce: ClubService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.service.getPlayer(params['uuid']).subscribe((player) => {
        this.player = player;
        this.clubId = player.clubName.id;
        this.clubSerivce.getClub(this.clubId).subscribe((club) => {
          this.clubName = club.name;
        });
      });
    });
  }
}
