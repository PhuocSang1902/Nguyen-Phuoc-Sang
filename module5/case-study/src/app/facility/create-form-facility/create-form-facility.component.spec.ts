import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFormFacilityComponent } from './create-form-facility.component';

describe('CreateFormFacilityComponent', () => {
  let component: CreateFormFacilityComponent;
  let fixture: ComponentFixture<CreateFormFacilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateFormFacilityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFormFacilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
