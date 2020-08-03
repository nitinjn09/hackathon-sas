import { Component, OnInit, Input } from '@angular/core';
import { Microservice } from '../microservice.model';
import { ActivatedRoute, Params, Route, Router } from '@angular/router';
import { MicroserviceService } from '../microservice.service';
import { DataFetcherService } from '../../shared/data-fetch.service';
import { DataUploadService } from '../../shared/data-upload.service';
import {HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-microservice-detail',
  templateUrl: './microservice-detail.component.html',
  styleUrls: ['./microservice-detail.component.css']
})
export class MicroserviceDetailComponent implements OnInit {

  microservice: Microservice;
  id: number;
	selectedFiles: File[];
	currentFile: File;
  afterUploadMsg;

  constructor(private microserviceService: MicroserviceService, 
              private route: ActivatedRoute,
              private router: Router,
              private dataFetcherService: DataFetcherService,
              private dataUploadService: DataUploadService) { }

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
  
  makeUploadFileOptionVisible(){
    console.log('inside makeUploadFileOptionVisible');
    var uploadFileDiv = document.getElementById('uploadFile');
    uploadFileDiv.style.display = 'inline';
  }

  selectFile(event) {
    this.selectedFiles = Array.from(event.target.files);
  }

  onUploadFile(){

    this.currentFile = this.selectedFiles[0];
    this.dataUploadService.uploadFile(this.currentFile).subscribe(response => {
		this.selectedFiles.splice(0,this.selectedFiles.length);
     if (response instanceof HttpResponse) {
     this.afterUploadMsg = response.body;
     console.log(response.body);
      }	  
    });    

  }


}
