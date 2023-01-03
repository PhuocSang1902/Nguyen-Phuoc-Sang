import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAddContractDetailComponent } from './modal-add-contract-detail.component';

describe('ModalAddContractDetailComponent', () => {
  let component: ModalAddContractDetailComponent;
  let fixture: ComponentFixture<ModalAddContractDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalAddContractDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalAddContractDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
