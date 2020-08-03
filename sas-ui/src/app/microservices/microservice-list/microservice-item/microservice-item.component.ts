import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Microservice } from '../../microservice.model';
import { MicroserviceService } from '../../microservice.service';

@Component({
  selector: 'app-microservice-item',
  templateUrl: './microservice-item.component.html',
  styleUrls: ['./microservice-item.component.css']
})
export class MicroserviceItemComponent implements OnInit {

  @Input() microservice: Microservice;
  @Input() index: number
  
  constructor(private microserviceService: MicroserviceService) { }

  ngOnInit(): void {
  }

  

}
