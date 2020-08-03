import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { MicroserviceService } from "../microservices/microservice.service";
import * as fileSaver from 'file-saver';
import { stringify } from "querystring";

@Injectable({providedIn: 'root'})
export class DataFetcherService{

    constructor(private http: HttpClient,private microservice:MicroserviceService){
        
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
            this.http.get('http://localhost:8082//pm-logs',{responseType:'text'})
            .subscribe(downloadedFileData => {
                const blob = new Blob([downloadedFileData], { type: 'text/json; charset=utf-8' });
                fileSaver.saveAs(blob, 'projectManager.log');
                console.log(downloadedFileData);
            });
        }
        
        
    }


    fetchConfiguration(id: number){
        const name = this.microservice.getMicroservice(id).name;
        console.log(name);      
        if(name === 'Project Manager')
        {
            this.http.get('http://localhost:8082//config',{responseType:'text'})
            .subscribe(configu => {
                this.confStr = configu;
                console.log(this.confStr);
            });
        }
        return this.confStr;
    }

    downloadConfig(id:number){
        const name = this.microservice.getMicroservice(id).name;
        console.log(name);      
        if(name === 'Project Manager')
        {
            this.http.get('http://localhost:8082//config',{responseType:'text'})
            .subscribe(downloadedFileData => {
                const blob = new Blob([downloadedFileData], { type: 'text/json; charset=utf-8' });
                fileSaver.saveAs(blob, 'projectManagerConfig.log');
                console.log(downloadedFileData);
            });
        }
    }
}