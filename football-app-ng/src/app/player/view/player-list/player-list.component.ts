import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../../service/player.service';
import { Players } from '../../model/players';
import { Player } from '../../model/player';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css'],
})
export class PlayerListComponent implements OnInit {
  constructor(private service: PlayerService) {}

  players: Players | undefined;

  ngOnInit(): void {
    this.service.getPlayers().subscribe((players) => (this.players = players));
  }

  onDelete(player: Player): void {
    this.service.deletePlayer(player.id).subscribe(() => this.ngOnInit());
  }
}
