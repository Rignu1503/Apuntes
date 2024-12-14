import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes-hero',
  standalone: false,
  templateUrl: './hero.component.html',
  styleUrl: './hero.component.css'
})
export class HeroComponent {

  public name: string = 'Iron Man';
  public age:  Number = 45;


  public get capitalizadName() : string {
    return this.name.toUpperCase();
  }

  getHeroDescription():string{
    return `${this.name} - ${this.age}`;
  }

  chageAge(): void{
    this.age = 50;
  }

  chageHero(): void{
    this.name = "Batman";
  }

  ResetFrom(): void{
    this.name = "Iron Man";
    this.age = 45;
  }

}
