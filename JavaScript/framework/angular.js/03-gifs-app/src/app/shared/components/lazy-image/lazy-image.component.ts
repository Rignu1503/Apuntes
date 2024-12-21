import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'shared-lazy-image',
  standalone: false,

  templateUrl: './lazy-image.component.html',
})
export class LazyImageComponent implements OnInit {

  @Input()
  public url!: string;

  @Input()
  public alt: string = 'Image';


  public hasLoaded: boolean = false;

  ngOnInit(): void {
    if(!this.url) throw new Error('Url is required');
  }

  public onImageLoad(): void {
    this.hasLoaded = true;
  }





}
