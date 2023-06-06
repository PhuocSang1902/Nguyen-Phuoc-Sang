import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoHangEditComponent } from './lo-hang-edit.component';

describe('LoHangEditComponent', () => {
  let component: LoHangEditComponent;
  let fixture: ComponentFixture<LoHangEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoHangEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoHangEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
