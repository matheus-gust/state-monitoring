import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DetailComponent } from './detail/detail.component';
import { PoModule, PoPageModule, PoTableModule, PoWidgetModule } from '@po-ui/ng-components';
import { FormsModule } from '@angular/forms';
import { PoChartModule } from '@po-ui/ng-components';



@NgModule({
  declarations: [
    DetailComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    PoPageModule,
    PoModule,
    PoChartModule
  ]
})
export class DetailModule { }
