import { Injectable } from "@angular/core";
import { HttpClient, HttpRequest, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import {Observable} from 'rxjs';
import { MicroserviceService } from "../microservices/microservice.service";
import { EnvService } from '../microservices/env.service';

@Injectable({providedIn: 'root'})
export class DataUploadService{

    constructor(private env: EnvService, private http: HttpClient,private microservice:MicroserviceService){

    }
 
    uploadFile(file: File): Observable<HttpEvent<{}>> {
      const formdata: FormData = new FormData();
      formdata.append('File', file);
      const req = new HttpRequest('POST', this.env.apiUrl + '//upload-conf/', formdata, {
          reportProgress: true,
          responseType: 'text'
      });
    
      return this.http.request(req);
     }
}