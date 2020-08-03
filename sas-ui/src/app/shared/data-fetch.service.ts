import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { MicroserviceService } from "../microservices/microservice.service";
import { DomSanitizer } from '@angular/platform-browser';
import * as fileSaver from 'file-saver';

@Injectable({providedIn: 'root'})
export class DataFetcherService{
    fileUrl;

    constructor(private http: HttpClient,private microservice:MicroserviceService, private sanitizer: DomSanitizer){

    }

    storeMicroservices(){
        //const microservices = this.microserviceService.getMicroservices();
        //this.http.post.put('');
    }

    fetchMicroservices(id: number){
           
        const name = this.microservice.getMicroservice(id).name;
        console.log(name);      
        if(name === 'Project Manager')
        {
            this.http.get('http://localhost:8082/collect-logs',{responseType:'text'})
            .subscribe(downloadedFileData => {
                const blob = new Blob([downloadedFileData], { type: 'text/json; charset=utf-8' });
                fileSaver.saveAs(blob, 'projectManager.log');
                console.log(downloadedFileData);
            });
        }
        
        
    }
}