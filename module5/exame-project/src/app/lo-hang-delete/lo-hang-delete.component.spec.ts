import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoHangDeleteComponent } from './lo-hang-delete.component';

describe('LoHangDeleteComponent', () => {
  let component: LoHangDeleteComponent;
  let fixture: ComponentFixture<LoHangDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoHangDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoHangDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
