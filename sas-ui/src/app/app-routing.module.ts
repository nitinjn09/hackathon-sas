import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MicroservicesComponent } from './microservices/microservices.component';
import { MicroserviceStartComponent } from './microservices/microservice-start/microservice-start.component';
import { MicroserviceDetailComponent } from './microservices/microservice-detail/microservice-detail.component';
import { MicroserviceEditComponent } from './microservices/microservice-edit/microservice-edit.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/microservices', pathMatch: 'full' },
  { path: 'microservices', component: MicroservicesComponent, children: [
    {path: '', component: MicroserviceStartComponent},
    {path: 'new', component: MicroserviceEditComponent},
    {path: ':id', component: MicroserviceDetailComponent},
    {path: ':id/edit', component: MicroserviceEditComponent}
  ] },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
