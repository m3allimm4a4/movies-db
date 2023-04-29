import { Creator } from './creator.interface';
import { Genre } from './genre.interface';

export interface MovieDetails {
  id: number;
  title: string;
  overview: string;
  popularity: number;
  releaseDate: Date;
  backdropUrl: string | null;
  posterUrl: string | null;
  genres: Genre[];
  rating: number;
  creators: Creator[];
}
