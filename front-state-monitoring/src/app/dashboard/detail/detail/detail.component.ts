import { Component, OnInit } from '@angular/core';
import { PoChartOptions, PoChartSerie, PoChartType, PoTableColumn, PoTableRowTemplateArrowDirection } from '@po-ui/ng-components';
import { HttpRequestModel } from '../shared/model/http-request.model';
import { DetailService } from '../shared/services/datail.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  columns: any;
  items: HttpRequestModel[] = [];
  health: any = {};

  participationByCountryInWorldExportsType: PoChartType = PoChartType.Line;
  
  poTableRowTemplateArrowDirection = PoTableRowTemplateArrowDirection.Right;

  requestType = [
    'GET',
    'POST', 
    'PUT',
    'DELETE'
  ]

  constructor(
    private detailService: DetailService
  ) { }

  ngOnInit(): void {
    this.getHttpRequestItems();
    this.getDatabaseHelth();
  }

  options: PoChartOptions = {
    axis: {
      minRange: 0,
      maxRange: 10,
      gridLines: 5
    }
  };

  categories: Array<string> = ['1', '2', '3', '4', '5'];

  participationByCountryInWorldExports: Array<PoChartSerie> = [];

  getDatabaseHelth() {
    this.detailService.getDatabaseHelth().subscribe(
      (response: any) => {
        this.health = response['components'];
      }
    )
  }

  getHttpRequestItems() {
    this.detailService.getHttpRequestItems().subscribe(
      {
        next: (response: HttpRequestModel[]) => {
          response.forEach((item) => {
            this.items.push({method: item.method, requestDateTime: item.requestDateTime, requestedUrl: item.requestedUrl, sender: item.sender, status: item.status})
          });
          this.defineGrafico()
        }
      }
    );
  }

  defineGrafico() {
    let itemAgrupados = new Map<String, HttpRequestModel[]>();
    this.requestType.forEach(tipo => {
      itemAgrupados.set(tipo, this.items.filter(item => item.method === tipo));
    });

    let horaAtual = new Date().getHours();

    let itemAgrupadosHora = new Map<string, any>();

    let itemHora = new Map<string, number[]>();

    this.requestType.forEach(tipo => {
      itemHora.set(tipo, []);
      this.categories.forEach(hora => {{
        itemHora.get(tipo).push(itemAgrupados.get(tipo).filter(req => horaAtual - new Date(req.requestDateTime).getHours() == Number.parseInt(hora)).length)
      }});
    })

    for(let key of itemHora.keys()) {
      this.participationByCountryInWorldExports.push({
        label: key, data: itemHora.get(key)
      })
    }

    console.log(this.participationByCountryInWorldExports)
  }
}
