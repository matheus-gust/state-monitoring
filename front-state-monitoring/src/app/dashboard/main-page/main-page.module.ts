import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './main-page/main-page.component';
import { PoFieldModule, PoInfoModule, PoPageModule, PoTableModule, PoWidgetModule } from '@po-ui/ng-components';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    MainPageComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    PoPageModule,
    PoTableModule,
    PoWidgetModule,
    PoFieldModule,
    PoInfoModule
  ]
})
export class MainPageModule { }
