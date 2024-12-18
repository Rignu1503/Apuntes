import { EventEmitter, Injectable, Output } from '@angular/core';
import { v4 as uuid} from 'uuid';
import { Character } from '../interfaces/character.interface';


@Injectable({
  providedIn: 'root'
})
export class dbzService {

  public characters: Character[] = [{
    id: uuid(),
    name: 'Goku',
    power: 5000,
  },{
    id: uuid(),
    name: 'Vegeta',
    power: 3000,
  },{
    id: uuid(),
    name: 'Trunks',
    power: 4000,
  }];

  addCharacter(character: Character): void{

    // const newCharacter: Character = {
    //   id: uuid(),
    //   name: character.name,
    //   power: character.power,
    // }
  const newCharacter: Character = {id: uuid(), ...character};

    this.characters.push(newCharacter)
  }

  deleteCharacterById(id:string | undefined){
    this.characters = this.characters.filter(character => character.id !== id);
  }


  // constructor() { }

}
