import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { MicroserviceService } from "../microservices/microservice.service";
import * as fileSaver from 'file-saver';
import { stringify } from "querystring";
import { Observable } from 'rxjs';
import { EnvService } from '../microservices/env.service';

@Injectable({providedIn: 'root'})
export class DataFetcherService{

    constructor(private env: EnvService, private http: HttpClient,private microservice:MicroserviceService){
        
    }

    myFiles:string [] = [];
    sMsg:string = '';
    confStr:string = ''; 
  
    storeMicroservices(){
        //const microservices = this.microserviceService.getMicroservices();
        //this.http.post.put('');
    }

    fetchMicroservices(id: number){
           
        const name = this.microservice.getMicroservice(id).name;
        console.log(name);      
        if(name === 'Project Manager')
        {
            if(this.env.enableDebug) {
                console.log('Debug mode enabled!');
              }

            console.log(this.env.apiUrl);

              this.http.get(this.env.apiUrl + '//pm-logs',{responseType:'text'})
              .subscribe(downloadedFileData => {
                const blob = new Blob([downloadedFileData], { type: 'text/json; charset=utf-8' });
                fileSaver.saveAs(blob, 'projectManager.log');
                console.log(downloadedFileData);
            });
        }
        
        
    }


    fetchConfiguration(id: number) : Observable<string>{
        const name = this.microservice.getMicroservice(id).name;
        console.log(name);      
        if(name === 'Project Manager')
        {
            return this.http.get(this.env.apiUrl + '//config',{responseType:'text'});
        }
    }

    downloadConfig(id:number){
        const name = this.microservice.getMicroservice(id).name;
        console.log(name);      
        if(name === 'Project Manager')
        {
            this.http.get(this.env.apiUrl + '//config',{responseType:'text'})
            .subscribe(downloadedFileData => {
                const blob = new Blob([downloadedFileData], { type: 'text/json; charset=utf-8' });
                fileSaver.saveAs(blob, 'projectManagerConfig.log');
                console.log(downloadedFileData);
            });
        }
    }

    downloadDBSnap(id:number){
        const name = this.microservice.getMicroservice(id).name;
        console.log(name);      
        if(name === 'Project Manager')
        {
            return this.http.get(this.env.apiUrl + '//config',{responseType:'text'});
        }
    }

}