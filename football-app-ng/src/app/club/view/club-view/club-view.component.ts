import { Component, OnInit } from '@angular/core';
import { ClubDetails } from '../../model/ClubDetails';
import { ClubService } from '../../service/club.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from 'src/app/player/service/player.service';
import { NewPlayer } from 'src/app/player/model/player-new';

@Component({
  selector: 'app-club-view',
  templateUrl: './club-view.component.html',
  styleUrls: ['./club-view.component.css'],
})
export class ClubViewComponent implements OnInit {
  clubPlayers: ClubDetails | any;
  club: ClubDetails | any;
  clubId: string = '';
  newPlayerId: string = '';
  newPlayer: NewPlayer = { name: '', surname: '', age: 0, club: '' };
  constructor(
    private clubService: ClubService,
    private playerService: PlayerService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.playerService.getClubPlayers(params['uuid']).subscribe((clubPlayers) => {
        this.clubPlayers = clubPlayers;
        this.clubId = params['uuid'];
        console.log(this.clubPlayers);
      });
      this.clubService.getClub(params['uuid']).subscribe((club) => {
        this.club = club;
        console.log(this.clubPlayers);
      });
    });
  }
  onSubmit(): void {
    this.newPlayer.club = this.clubId;

    this.playerService
      .putPlayer(this.newPlayerId, this.newPlayer)
      .subscribe(() => this.router.navigate(['/players']));
  }
}
