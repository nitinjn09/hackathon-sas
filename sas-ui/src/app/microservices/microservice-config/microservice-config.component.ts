import { Component, OnInit } from '@angular/core';
import { MicroserviceService } from '../microservice.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { DataFetcherService } from '../../shared/data-fetch.service';
import { Microservice } from '../microservice.model';

@Component({
  selector: 'app-microservice-config',
  templateUrl: './microservice-config.component.html',
  styleUrls: ['./microservice-config.component.css']
})
export class MicroserviceConfigComponent implements OnInit {

   configMS;
   id: number;
   microservice: Microservice;

  constructor(private route: ActivatedRoute, private microserviceService:MicroserviceService, private router: Router,private dataFetcherService: DataFetcherService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id=+params['id'];
      this.microservice= this.microserviceService.getMicroservice(this.id);
  });
  }

  onCancel(){
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  onGetConfig(){
    this.configMS = this.dataFetcherService.fetchConfiguration(this.id).subscribe(result =>
      {
        this.configMS = result;
      });
  }

  onDownload(){
    this.dataFetcherService.downloadConfig(this.id);
  }



}
