import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditFormFacilityComponent } from './edit-form-facility.component';

describe('EditFormFacilityComponent', () => {
  let component: EditFormFacilityComponent;
  let fixture: ComponentFixture<EditFormFacilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditFormFacilityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditFormFacilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
