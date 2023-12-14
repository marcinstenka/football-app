import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http"
import { Observable } from 'rxjs';
import { Clubs } from '../model/Clubs';
import { Club } from '../model/Club';
@Injectable({
  providedIn: 'root',
})
export class ClubService {
  constructor(private http: HttpClient) {}

  getClubs(): Observable<Clubs> {
    return this.http.get<Clubs>('/api/clubs');
  }
  deleteClub(uuid: string): Observable<any> {
    return this.http.delete<Club>(`/api/clubs/${uuid}`);
  }
}
