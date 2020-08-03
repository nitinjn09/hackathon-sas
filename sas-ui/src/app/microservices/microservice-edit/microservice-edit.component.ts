import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MicroserviceService } from '../microservice.service';
import { Microservice } from '../microservice.model';

@Component({
  selector: 'app-microservice-edit',
  templateUrl: './microservice-edit.component.html',
  styleUrls: ['./microservice-edit.component.css']
})
export class MicroserviceEditComponent implements OnInit {

  id: number;
  editMode = false;
  microserviceFrom: FormGroup;

  constructor(private route: ActivatedRoute, private microserviceService:MicroserviceService, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params)=>{
      this.id= +params['id'];
      this.editMode = params['id'] != null;
      this.initForm();
    });
  }

  onSubmit(){
    const newMicroservice = new Microservice(this.microserviceFrom.value['name'],
                                            this.microserviceFrom.value['description']);
    if (this.editMode){
      this.microserviceService.updateMicroservice(this.id, newMicroservice);
    }else{
      this.microserviceService.addMicroservice(newMicroservice);
    }
    this.onCancel();
  }

  onCancel(){
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  private initForm(){
      
      let microserviceName = '';
      let microserviceDescription = '';

      if(this.editMode){
        const microservice = this.microserviceService.getMicroservice(this.id);
        microserviceName = microservice.name;
        microserviceDescription = microservice.description;

      }

      this.microserviceFrom= new FormGroup({
          'name': new FormControl(microserviceName, Validators.required),
          'description' : new FormControl(microserviceDescription)
      });
  }

}
