import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AsideComponent } from './components/aside/aside.component';
import { LazyImageComponent } from './components/lazy-image/lazy-image.component';



@NgModule({
  declarations: [
    AsideComponent,
    LazyImageComponent
  ],
  imports: [
    CommonModule
  ], exports: [
    AsideComponent,
    LazyImageComponent
  ]
})
export class SharedModule { }
