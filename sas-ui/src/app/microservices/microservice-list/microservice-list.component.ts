import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { Microservice } from '../microservice.model';
import { MicroserviceService } from '../microservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-microservice-list',
  templateUrl: './microservice-list.component.html',
  styleUrls: ['./microservice-list.component.css']
})
export class MicroserviceListComponent implements OnInit {

  microservices: Microservice[];

  constructor(private microserviceService: MicroserviceService,
              private router: Router,
              private route: ActivatedRoute) { 

  }

  ngOnInit(): void {
    this.microservices = this.microserviceService.getMicroservices();
  }

  onNewMicroService() {
    this.router.navigate(['new'], {relativeTo: this.route});
  }

}
