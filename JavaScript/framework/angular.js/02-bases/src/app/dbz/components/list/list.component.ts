import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Character } from '../../interfaces/character.interface';

@Component({
  selector: 'dbz-list',
  standalone: false,

  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent {


    @Output()
    public OnDelete: EventEmitter<string> = new EventEmitter();


  @Input()
  public characterList: Character[] = [{
    name: 'Goku',
    power: 20
  }]


  onDeleteCharacter(id?: string): void{

    if(!id) return;
    //Emitir el ID del personaje
    this.OnDelete.emit(id);
  }








}
