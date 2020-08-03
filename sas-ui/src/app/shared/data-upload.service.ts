import { Injectable } from "@angular/core";
import { HttpClient, HttpRequest, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import {Observable} from 'rxjs';
import { MicroserviceService } from "../microservices/microservice.service";

@Injectable({providedIn: 'root'})
export class DataUploadService{

    constructor(private http: HttpClient,private microservice:MicroserviceService){

    }
 
    uploadFile(file: File): Observable<HttpEvent<{}>> {
      const formdata: FormData = new FormData();
      formdata.append('File', file);
      const req = new HttpRequest('POST', 'http://localhost:8082//upload-conf/', formdata, {
          reportProgress: true,
          responseType: 'text'
      });
    
      return this.http.request(req);
     }
}