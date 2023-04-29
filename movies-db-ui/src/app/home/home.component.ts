import { Component } from '@angular/core';
import { Movie } from '../models/movie.interface';
import { MoviesService } from '../services/movies-service/movies.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  public moviesList: Movie[] = [];

  constructor(private movieService: MoviesService) {}

  public onSearchClicked(query: string) {
    this.movieService.getMoviesList(query).subscribe(movies => {
      this.moviesList = movies;
    });
  }
}
