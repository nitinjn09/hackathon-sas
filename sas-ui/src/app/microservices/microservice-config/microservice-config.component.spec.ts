import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MicroserviceConfigComponent } from './microservice-config.component';

describe('MicroserviceConfigComponent', () => {
  let component: MicroserviceConfigComponent;
  let fixture: ComponentFixture<MicroserviceConfigComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MicroserviceConfigComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MicroserviceConfigComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
