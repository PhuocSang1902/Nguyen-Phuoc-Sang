import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityCreateFormComponent } from './facility-create-form.component';

describe('FacilityCreateFormComponent', () => {
  let component: FacilityCreateFormComponent;
  let fixture: ComponentFixture<FacilityCreateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacilityCreateFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityCreateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
