import { Component, OnInit, Input } from '@angular/core';
import { Microservice } from '../microservice.model';
import { ActivatedRoute, Params, Route, Router } from '@angular/router';
import { MicroserviceService } from '../microservice.service';
import { DataFetcherService } from '../../shared/data-fetch.service';

@Component({
  selector: 'app-microservice-detail',
  templateUrl: './microservice-detail.component.html',
  styleUrls: ['./microservice-detail.component.css']
})
export class MicroserviceDetailComponent implements OnInit {

  microservice: Microservice;
  id: number;

  constructor(private microserviceService: MicroserviceService, 
              private route: ActivatedRoute,
              private router: Router,
              private dataFetcherService: DataFetcherService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
        this.id=+params['id'];
        this.microservice= this.microserviceService.getMicroservice(this.id);
    });
  }

  onEditMicroservice(){
    this.router.navigate(['edit'], {relativeTo: this.route});
  }

  onDeleteMicroservice(){
    this.microserviceService.deletedMicroservice(this.id);
    this.router.navigate(['/microservices']);
  }

  onDownloadLogs(){
    this.dataFetcherService.fetchMicroservices(this.id);
  }
  
  onUploadFile(){
    //this.dataFetcherService.uploadDataonMicroservice(this.id);

  }

}
