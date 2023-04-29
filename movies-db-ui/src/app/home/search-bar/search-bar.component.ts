import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.scss'],
})
export class SearchBarComponent {
  @Output() searchClicked = new EventEmitter<string>();
  public query = '';

  public onSubmit() {
    if (this.query) {
      this.searchClicked.emit(this.query);
    }
  }
}
