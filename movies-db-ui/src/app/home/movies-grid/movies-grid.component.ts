import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie.interface';

@Component({
  selector: 'app-movies-grid',
  templateUrl: './movies-grid.component.html',
  styleUrls: ['./movies-grid.component.scss'],
})
export class MoviesGridComponent {
  @Input() moviesList: Movie[] = [];

  constructor(private router: Router) {}

  onMovieClick(id: number) {
    this.router.navigate(['/movie', id]);
  }
}
