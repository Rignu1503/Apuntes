import { Component } from '@angular/core';
import { GifsService } from '../../../gifs/services/gifs.service';

@Component({
  selector: 'shared-aside',
  standalone: false,

  templateUrl: './aside.component.html',
  styleUrl: './aside.component.css'
})
export class AsideComponent {

  constructor(private gifsService: GifsService){}

    get tags(){
      return this.gifsService.tagHistory;
    }

    searchTag(tag : string): void{
      this.gifsService.searchTag( tag );
    }



}
