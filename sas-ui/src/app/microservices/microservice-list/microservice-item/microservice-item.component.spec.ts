import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MicroserviceItemComponent } from './microservice-item.component';

describe('MicroserviceItemComponent', () => {
  let component: MicroserviceItemComponent;
  let fixture: ComponentFixture<MicroserviceItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MicroserviceItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MicroserviceItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
