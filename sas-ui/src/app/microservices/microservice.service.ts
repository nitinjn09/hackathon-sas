import { Microservice } from "./microservice.model";
import { Subject } from "rxjs";
import { EventEmitter, Injectable } from "@angular/core";


@Injectable()
export class MicroserviceService{

    microserviceSelected = new EventEmitter<Microservice>();

    private microservices: Microservice[] = [
        new Microservice('Generate Site Config Report', 'Responsible for generating site config report.'),
        new Microservice('Calculate Prov. Link Agg. BW', "It will calculate aggregate bandwidth of all prov. links in network."),
        new Microservice('DB Core', 'Microservice which handles DB operation')
      ];

    getMicroservices(){
        return this.microservices;
    }

    getMicroservice(index: number){
        return this.microservices[index];
    }

    addMicroservice(microservice: Microservice){
        this.microservices.push(microservice);
    }

    updateMicroservice(index: number, newMicroService: Microservice){
        this.microservices[index]=newMicroService;
    }

    deletedMicroservice(index: number){
        this.microservices.splice(index, 1);
    }


}