import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractCreateFormComponent } from './contract-create-form.component';

describe('ContractCreateFormComponent', () => {
  let component: ContractCreateFormComponent;
  let fixture: ComponentFixture<ContractCreateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContractCreateFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractCreateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
