import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerUseFacilityComponent } from './customer-use-facility.component';

describe('CustomerUseFacilityComponent', () => {
  let component: CustomerUseFacilityComponent;
  let fixture: ComponentFixture<CustomerUseFacilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerUseFacilityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerUseFacilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
