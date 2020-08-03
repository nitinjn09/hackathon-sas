import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MicroserviceDetailComponent } from './microservice-detail.component';

describe('MicroserviceDetailComponent', () => {
  let component: MicroserviceDetailComponent;
  let fixture: ComponentFixture<MicroserviceDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MicroserviceDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MicroserviceDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
