import { Component, ElementRef, ViewChild } from '@angular/core';
import { GifsService } from '../../services/gifs.service';

@Component({
  standalone: false,
  selector: 'gifs-search-box',
  template:`
  <h5>Buscar</h5>
  <input type="text"
  class="from-control"
  placeholder="Buscar gifs..."
  (keyup.enter)="searchTag()"
  #txtTagInpug
  >
  `
})

export class SearchBoxComponent{

  @ViewChild('txtTagInpug')
  public tagInput!: ElementRef<HTMLInputElement>;

  constructor( private gifsService: GifsService ) {

   }

  // searchTag(newTag: string){
  //No es necesario crear llamar el elemento porque ya esta referenciado
  searchTag(){
    const newTag = this.tagInput.nativeElement.value;

    this.gifsService.searchTag(newTag);

    this.tagInput.nativeElement.value = '';

  }

}
