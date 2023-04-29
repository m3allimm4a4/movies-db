import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { MoviesGridComponent } from './movies-grid/movies-grid.component';
import { SearchBarComponent } from './search-bar/search-bar.component';

@NgModule({
  declarations: [HomeComponent, SearchBarComponent, MoviesGridComponent],
  imports: [CommonModule, FormsModule, HomeRoutingModule],
})
export class HomeModule {}
