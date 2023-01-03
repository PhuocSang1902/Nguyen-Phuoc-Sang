import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAttachFacilityComponent } from './modal-attach-facility.component';

describe('ModalAttachFacilityComponent', () => {
  let component: ModalAttachFacilityComponent;
  let fixture: ComponentFixture<ModalAttachFacilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalAttachFacilityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalAttachFacilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
