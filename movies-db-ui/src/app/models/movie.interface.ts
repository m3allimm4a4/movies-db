import { Genre } from './genre.interface';

export interface Movie {
  id: number;
  title: string;
  overview: string;
  popularity: number;
  releaseDate: Date;
  backdropUrl: null | string;
  posterUrl: string;
  genres?: Genre[];
}
