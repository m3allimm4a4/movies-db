import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Movie } from 'src/app/models/movie.interface';
import { MoviesListResponse } from 'src/app/models/movies-list-response.interface';
import { AppConfigService } from '../app-config-service/app-config.service';
import { MovieDetailsResponse } from 'src/app/models/movie-details-response';

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
      .get<MoviesListResponse>(`${this.apiUrl}/search/movie`, {
        params: params,
      })
      .pipe(
        map(response => {
          return response.results.map(m => {
            const movie: Movie = {
              id: m.id,
              title: m.title,
              overview: m.overview,
              popularity: m.popularity,
              releaseDate: new Date(m.release_date),
              posterUrl: this.appConfigService.getImageUrl(m.poster_path),
              backdropUrl: this.appConfigService.getImageUrl(m.backdrop_path),
            };
            return movie;
          });
        })
      );
  }

  public getMovieDetails(id: number): Observable<Movie> {
    return this.http.get<MovieDetailsResponse>(`${this.apiUrl}/movie/${id}`).pipe(
      map(m => {
        const movie: Movie = {
          id: m.id,
          overview: m.overview,
          title: m.title,
          releaseDate: new Date(m.release_date),
          genres: m.genres,
          posterUrl: this.appConfigService.getImageUrl(m.poster_path),
          backdropUrl: this.appConfigService.getImageUrl(m.backdrop_path),
          popularity: m.popularity,
        };
        return movie;
      })
    );
  }
}
