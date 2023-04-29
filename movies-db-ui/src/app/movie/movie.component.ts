import { Component, OnInit } from '@angular/core';
import { Movie } from '../models/movie.interface';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss'],
})
export class MovieComponent implements OnInit {
  public movie: Movie = {} as Movie;

  ngOnInit(): void {}
}
