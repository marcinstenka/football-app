import { Club } from 'src/app/club/model/Club';

export interface PlayerDetails {
  id: string;
  name: string;
  surname: string;
  age: number;
  club: Club;
}
