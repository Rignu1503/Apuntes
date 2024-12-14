import { NgModule } from '@angular/core';
import { CountertComponent } from './components/counter/counter.component';

@NgModule({
  declarations: [
    CountertComponent, // Declarar el componente
  ],
  exports: [
    CountertComponent, // Exportar el componente
  ],
})
export class CounterModule { }
