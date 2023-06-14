import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Movie } from 'src/app/models/movie.interface';
import { MovieResponse } from 'src/app/models/movies-list-response.interface';
import { AppConfigService } from '../app-config-service/app-config.service';
import { MovieDetailsResponse } from 'src/app/models/movie-details-response';
import { MovieDetails } from 'src/app/models/movie-details.interface';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {
  private apiUrl: string;

  constructor(private http: HttpClient, private appConfigService: AppConfigService) {
    this.apiUrl = appConfigService.apiUrl;
  }

  public getMoviesList(query: string): Observable<Movie[]> {
    const params = new HttpParams().append('query', query);
    return this.http
      .get<MovieResponse[]>(`${this.apiUrl}/movie/searchMovies`, {
        params: params,
      })
      .pipe(
        map(response => {
          return response.map(m => {
            const movie: Movie = {
              id: m.id,
              title: m.title,
              overview: m.overview,
              popularity: m.popularity,
              releaseDate: new Date(m.releaseDate),
              backdropUrl: this.appConfigService.getImageUrl(m.backdropPath),
            };
            return movie;
          });
        })
      );
  }

  public getMovieDetails(id: number): Observable<MovieDetails> {
    return this.http.get<MovieDetailsResponse>(`${this.apiUrl}/movie/getMovieDetails/${id}`).pipe(
      map(m => {
        const movie: MovieDetails = {
          id: m.id,
          overview: m.overview,
          title: m.title,
          releaseDate: new Date(m.releaseDate),
          genres: m.genres,
          rating: m.rating,
          popularity: m.popularity,
          creators: m.creators,
          posterUrl: this.appConfigService.getImageUrl(m.posterPath),
          backdropUrl: this.appConfigService.getImageUrl(m.backdropPath),
        };
        return movie;
      })
    );
  }
}
