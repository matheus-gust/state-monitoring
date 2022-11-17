import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageModule } from './main-page/main-page.module';
import { DetailModule } from './detail/detail.module';
import { DashboardRoutingModule } from './dashboard-routing.module';



@NgModule({
  declarations: [],
  imports: [
    MainPageModule,
    DetailModule,
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
