import { Creator } from './creator.interface';
import { Genre } from './genre.interface';

export interface MovieDetailsResponse {
  id: number;
  title: string;
  overview: string;
  popularity: number;
  releaseDate: Date;
  backdropPath: string;
  posterPath: string;
  rating: number;
  genres: Genre[];
  creators: Creator[];
}
