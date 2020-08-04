import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';
import { ServersComponent } from './servers/servers.component';
import { HeaderComponent } from './header/header.component';
import { MicroservicesComponent } from './microservices/microservices.component';
import { MicroserviceListComponent } from './microservices/microservice-list/microservice-list.component';
import { MicroserviceDetailComponent } from './microservices/microservice-detail/microservice-detail.component';
import { MicroserviceItemComponent } from './microservices/microservice-list/microservice-item/microservice-item.component';
import { DropdownDirective } from './shared/dropdown.directive';
import { MicroserviceStartComponent } from './microservices/microservice-start/microservice-start.component';
import { MicroserviceEditComponent } from './microservices/microservice-edit/microservice-edit.component';
import { MicroserviceService } from './microservices/microservice.service';
import { MicroserviceConfigComponent } from './microservices/microservice-config/microservice-config.component';
import { DbsnapComponent } from './microservices/dbsnap/dbsnap.component';
import {TableModule} from 'primeng/table';
import { EnvServiceProvider } from './microservices/env.service.provider';

@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    ServersComponent,
    HeaderComponent,
    MicroservicesComponent,
    MicroserviceListComponent,
    MicroserviceDetailComponent,
    MicroserviceItemComponent,
    DropdownDirective,
    MicroserviceStartComponent,
    MicroserviceEditComponent,
    MicroserviceConfigComponent,
    DbsnapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    TableModule,
    HttpClientModule
],
  providers: [MicroserviceService,
              EnvServiceProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
