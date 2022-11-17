import { Component } from '@angular/core';

import { PoMenuItem } from '@po-ui/ng-components';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor() {
    this.definirMenus();
  }

  menu: any;

  menuItemSelected: string = "";

  readonly menus: Array<PoMenuItem> = [
    { label: 'Home', action: this.onClick.bind(this) }
  ];

  private onClick() {
    alert('Clicked in menu item')
  }

  printMenuAction(menu: PoMenuItem) {
    this.menuItemSelected = menu.label;
  }

  private definirMenus() {
    this.menu = [
      {
        label: 'Dashboard',
        action: this.printMenuAction.bind(this),
        link: 'dashboard/home',
        icon: 'po-icon-layers',
        shortLabel: 'Dash'
      }
    ];
  }

}
