import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityEditFormComponent } from './facility-edit-form.component';

describe('FacilityEditFormComponent', () => {
  let component: FacilityEditFormComponent;
  let fixture: ComponentFixture<FacilityEditFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacilityEditFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityEditFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
