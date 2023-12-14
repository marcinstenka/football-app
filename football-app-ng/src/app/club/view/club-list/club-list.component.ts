import { Component, OnInit } from '@angular/core';
import { ClubService } from '../../service/club.service';
import { Clubs } from '../../model/Clubs';
import { Club } from '../../model/Club';
import { ClubForm } from '../../model/ClubForm';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-club-list',
  templateUrl: './club-list.component.html',
  styleUrls: ['./club-list.component.css'],
})
export class ClubListComponent implements OnInit {
  constructor(
    private service: ClubService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  clubs: Clubs | undefined;
  newClub: ClubForm = { id: '', name: '', foundingYear: 0 };

  ngOnInit(): void {
    this.service.getClubs().subscribe((clubs) => (this.clubs = clubs));
  }
  onDelete(club: Club): void {
    this.service.deleteClub(club.id).subscribe(() => this.ngOnInit());
  }
  onSubmit(): void {
    this.service
      .putClub(this.newClub.id, this.newClub)
      .subscribe(() => this.router.navigate(['/clubs']));
  }
}
