import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clubs } from '../model/Clubs';
import { Club } from '../model/Club';
import { ClubForm } from '../model/ClubForm';
import { ClubDetails } from '../model/ClubDetails';
@Injectable({
  providedIn: 'root',
})
export class ClubService {
  constructor(private http: HttpClient) {}

  getClubs(): Observable<Clubs> {
    return this.http.get<Clubs>('/api/clubs');
  }
  getClub(uuid: string): Observable<ClubDetails> {
    return this.http.get<ClubDetails>(`/api/clubs/${uuid}`);
  }
  deleteClub(uuid: string): Observable<any> {
    return this.http.delete<Club>(`/api/clubs/${uuid}`);
  }
  putClub(uuid: string, request: ClubForm): Observable<any> {
    return this.http.put(`/api/clubs/${uuid}`, request);
  }
}
