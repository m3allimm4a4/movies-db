import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Movie } from 'src/app/models/movie.interface';
import { MoviesListResponse } from 'src/app/models/movies-list-response.interface';
import { AppConfigService } from '../app-config-service/app-config.service';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {
  private apiUrl: string;
  private apiKey: string;

  constructor(private http: HttpClient, private appConfigService: AppConfigService) {
    this.apiUrl = appConfigService.apiUrl;
    this.apiKey = appConfigService.apiKey;
  }

  public getMoviesList(query: string): Observable<Movie[]> {
    const params = new HttpParams().append('query', query).append('api_key', this.apiKey);
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

  public getMovieDetails(id: number) {}
}
