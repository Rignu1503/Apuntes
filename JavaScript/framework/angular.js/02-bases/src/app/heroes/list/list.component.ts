import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes-list',
  standalone: false,
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent {

  public heroName: string[] = ["spidwrman", "thor", "Hulk"];
  public deleteHero?: string;

  RemoveLastHeroe(): void{

    this.deleteHero = this.heroName.pop();
  }

}
