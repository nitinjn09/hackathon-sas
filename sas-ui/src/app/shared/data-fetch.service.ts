import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { MicroserviceService } from "../microservices/microservice.service";

@Injectable({providedIn: 'root'})
export class DataFetcherService{

    constructor(private http: HttpClient,private microservice:MicroserviceService){

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
            this.http.get('http://localhost:8082//pm-logs',{responseType:'text'})
            .subscribe(microservices => {
                console.log(microservices);
            });
        }
        
        
    }
}