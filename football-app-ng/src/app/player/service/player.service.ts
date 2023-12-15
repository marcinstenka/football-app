import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Players } from '../model/players';
import { PlayerDetails } from '../model/player-details';
import { PlayerForm } from '../model/player-form';
import { ClubDetails } from 'src/app/club/model/ClubDetails';

@Injectable({
  providedIn: 'root',
})
export class PlayerService {
  constructor(private http: HttpClient) {}

  getPlayers(): Observable<Players> {
    return this.http.get<Players>('/api/players');
  }

  getPlayer(uuid: string): Observable<PlayerDetails> {
    return this.http.get<PlayerDetails>(`/api/players/${uuid}`);
  }
  getClubPlayers(uuid: string): Observable<ClubDetails> {
    return this.http.get<ClubDetails>(`/api/clubs/${uuid}/players`);
  }

  deletePlayer(uuid: string): Observable<any> {
    return this.http.delete(`/api/players/${uuid}`);
  }

  putPlayer(uuid: string, request: PlayerForm): Observable<any> {
    return this.http.patch(
      `http://localhost:8083/api/players/${uuid}/update`,
      request
    );
  }
}
