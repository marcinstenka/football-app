import { Component } from '@angular/core';
import { ClubService } from '../../service/club.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ClubForm } from '../../model/ClubForm';

@Component({
  selector: 'app-club-edit',
  templateUrl: './club-edit.component.html',
  styleUrls: ['./club-edit.component.css'],
})
export class ClubEditComponent {
  uuid: string | undefined;

  club: ClubForm | undefined;

  original: ClubForm | undefined;
  constructor(
    private clubService: ClubService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.clubService.getClub(params['uuid']).subscribe((club) => {
        this.uuid = club.id;
        this.club = {
          id: club.id,
          name: club.name,
          foundingYear: club.foundingYear,
        };
        this.original = { ...this.club };
      });
    });
  }
  onSubmit(): void {
    this.clubService
      .patchClub(this.uuid!, this.club!)
      .subscribe(() => this.router.navigate(['/clubs']));
  }
}
