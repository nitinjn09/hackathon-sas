import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DbsnapComponent } from './dbsnap.component';

describe('DbsnapComponent', () => {
  let component: DbsnapComponent;
  let fixture: ComponentFixture<DbsnapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DbsnapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DbsnapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
