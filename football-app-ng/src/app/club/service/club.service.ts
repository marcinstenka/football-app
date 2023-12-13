import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http"
import { Observable } from 'rxjs';
import { Clubs } from '../model/Clubs';
@Injectable({
  providedIn: 'root'
})
export class ClubService {

  constructor(private http: HttpClient) { }

  getClubs(): Observable<Clubs>{
    return this.http.get<Clubs>('/api/clubs')
  }
}
