import { Player } from 'src/app/player/model/player';

export interface ClubDetails {
  id: string;
  name: string;
  foundingYear: number;
  players: Player[];
}
