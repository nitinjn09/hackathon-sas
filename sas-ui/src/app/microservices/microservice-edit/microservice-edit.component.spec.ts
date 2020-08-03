import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MicroserviceEditComponent } from './microservice-edit.component';

describe('MicroserviceEditComponent', () => {
  let component: MicroserviceEditComponent;
  let fixture: ComponentFixture<MicroserviceEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MicroserviceEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MicroserviceEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
