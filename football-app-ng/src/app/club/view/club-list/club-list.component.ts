import { Component, OnInit } from '@angular/core';
import { ClubService } from '../../service/club.service';
import { Clubs } from '../../model/Clubs';
import { Club } from '../../model/Club';

@Component({
  selector: 'app-club-list',
  templateUrl: './club-list.component.html',
  styleUrls: ['./club-list.component.css'],
})
export class ClubListComponent implements OnInit {
  constructor(private service: ClubService) {}

  clubs: Clubs | undefined;

  ngOnInit(): void {
    this.service.getClubs().subscribe((clubs) => (this.clubs = clubs));
  }
  onDelete(club: Club): void {
    this.service.deleteClub(club.id).subscribe(() => this.ngOnInit());
  }
}
