import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieComponent } from './movie.component';
import { FormsModule } from '@angular/forms';
import { MovieRoutingModule } from './movie-routing.module';

@NgModule({
  declarations: [MovieComponent],
  imports: [CommonModule, FormsModule, MovieRoutingModule],
})
export class MovieModule {}
