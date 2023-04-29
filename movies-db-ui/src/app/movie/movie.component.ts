import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap, tap, throwError } from 'rxjs';
import { MovieDetails } from '../models/movie-details.interface';
import { MoviesService } from '../services/movies-service/movies.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss'],
})
export class MovieComponent implements OnInit {
  public movie: MovieDetails | null = null;

  constructor(private route: ActivatedRoute, private movieService: MoviesService) {}

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap(paramMap => {
          const id = paramMap.get('id');
          if (!id) return throwError(() => new Error('Invalid movie ID'));

          return this.movieService.getMovieDetails(+id);
        }),
        tap(movie => {
          this.movie = movie;
        })
      )
      .subscribe();
  }
}
