import { Component, OnInit } from '@angular/core';
import { ClubDetails } from '../../model/ClubDetails';
import { ClubService } from '../../service/club.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-club-view',
  templateUrl: './club-view.component.html',
  styleUrls: ['./club-view.component.css'],
})
export class ClubViewComponent implements OnInit {
  club: ClubDetails | undefined;

  constructor(
    private service: ClubService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.service
        .getClub(params['uuid'])
        .subscribe((club) => (this.club = club));
    });
  }
}
