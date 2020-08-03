import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MicroserviceStartComponent } from './microservice-start.component';

describe('MicroserviceStartComponent', () => {
  let component: MicroserviceStartComponent;
  let fixture: ComponentFixture<MicroserviceStartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MicroserviceStartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MicroserviceStartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
