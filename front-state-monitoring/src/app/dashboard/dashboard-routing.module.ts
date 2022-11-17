import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailComponent } from './detail/detail/detail.component';
import { MainPageComponent } from './main-page/main-page/main-page.component';

const routes: Routes = [
    { path: '', redirectTo: 'dashboard/detail', pathMatch: 'full'},
    { path: 'dashboard', redirectTo: 'dashboard/detail', pathMatch: 'full'},
    { path: 'home', component: MainPageComponent},
    { path: 'detail', component: DetailComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule { }