import { Component, OnInit } from '@angular/core';
import { Microservice } from './microservice.model';
import { MicroserviceService } from './microservice.service';

@Component({
  selector: 'app-microservices',
  templateUrl: './microservices.component.html',
  styleUrls: ['./microservices.component.css'],
  providers: [MicroserviceService]
})
export class MicroservicesComponent implements OnInit {

  selectedmicroservice: Microservice;

  constructor(private microserviceService: MicroserviceService) { }

  ngOnInit(): void {
    this.microserviceService.microserviceSelected
      .subscribe((microservice: Microservice) => {
          this.selectedmicroservice = microservice;
      });
  }

}
