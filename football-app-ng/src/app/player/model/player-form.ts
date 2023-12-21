import { Club } from 'src/app/club/model/Club';

export interface PlayerForm {
  name: string;
  surname: string;
  age: number;
  club: Club;
}
