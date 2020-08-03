import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
    MicroserviceEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
