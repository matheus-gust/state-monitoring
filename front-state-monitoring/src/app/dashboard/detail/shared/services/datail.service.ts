import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpRequestModel } from "../model/http-request.model";

@Injectable({
    providedIn: 'root'
})
export class DetailService{

    private url = 'http://127.0.0.1:8080/dashboard';
    private urlHealth = 'http://127.0.0.1:8081/actuator/health';

    constructor(private http: HttpClient) {}

    getHttpRequestItems(): Observable<any> {
        return this.http.get<HttpRequestModel[]>(this.url + '/httprequest/list/091d2604-65ce-11ed-9022-0242ac120002');
    }

    getDatabaseHelth() {
        return this.http.get<any>(this.urlHealth);
    }
}