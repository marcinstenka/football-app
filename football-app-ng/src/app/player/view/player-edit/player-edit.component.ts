import { Component, OnInit } from '@angular/core';
import { Players } from '../../model/players';
import { PlayerService } from '../../service/player.service';
import { Player } from '../../model/player';
import { PlayerForm } from '../../model/player-form';
import { Clubs } from 'src/app/club/model/Clubs';
import { ActivatedRoute, Router } from '@angular/router';
import { ClubService } from 'src/app/club/service/club.service';

@Component({
  selector: 'app-player-edit',
  templateUrl: './player-edit.component.html',
  styleUrls: ['./player-edit.component.css'],
})
export class PlayerEditComponent implements OnInit {
  uuid: string | undefined;

  player: PlayerForm | undefined;

  original: PlayerForm | undefined;

  clubs: Clubs | undefined;

  constructor(
    private playerService: PlayerService,
    private clubService: ClubService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.clubService.getClubs().subscribe((clubs) => (this.clubs = clubs));
      this.playerService.getPlayer(params['uuid']).subscribe((player) => {
        this.uuid = player.id;
        this.player = {
          name: player.name,
          surname: player.surname,
          age: player.age,
          club: player.club,
        };
        this.original = { ...this.player };
      });
    });
  }

  onSubmit(): void {
    this.playerService
      .putPlayer(this.uuid!, this.player!)

      .subscribe(() => this.router.navigate(['/players']));
    console.log(this.player);
  }
}
