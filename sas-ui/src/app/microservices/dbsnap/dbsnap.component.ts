import { Component, OnInit } from '@angular/core';
import { MicroserviceService } from '../microservice.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { DataFetcherService } from '../../shared/data-fetch.service';
import { Microservice } from '../microservice.model';

@Component({
  selector: 'app-dbsnap',
  templateUrl: './dbsnap.component.html',
  styleUrls: ['./dbsnap.component.css']
})
export class DbsnapComponent implements OnInit {
  cols: any[];
  users: DataInterface[];

  constructor(private route: ActivatedRoute, private microserviceService:MicroserviceService, private router: Router,private dataFetcherService: DataFetcherService) { }

  ngOnInit(): void {
  }

  onCancel(){
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  onGetDBSnap(){
  }

}

export interface DataInterface {
  id;
  name;
}