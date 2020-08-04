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
  id: number;

  constructor(private route: ActivatedRoute, private microserviceService:MicroserviceService, private router: Router,private dataFetcherService: DataFetcherService) { }

  ngOnInit(): void {
  }

  onCancel(){
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  onGetDBSnap(){
    console.log('onGetDBSnap');
    this.dataFetcherService.downloadDBSnap(this.id).subscribe(jsonfile =>
      {
        console.log('downloadDBSnap inside subscribe');
        console.log('json ->' + jsonfile);

        let data = JSON.parse(jsonfile);
        this.users = [
          { id: data["Project 1"].event, name: data["Project 1"].data },
          { id: data["Project 2"].event, name: data["Project 2"].data },
          { id: data["Project 3"].event, name: data["Project 3"].data }];
          this.cols = [
            { field: 'id', header: 'Id' },
            { field: 'name', header: 'Name' },
        ];
  
          console.log('users ->' + this.users);

      });
  }

}

export interface DataInterface {
  id;
  name;
}