import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoHangComponent } from './lo-hang.component';

describe('LoHangComponent', () => {
  let component: LoHangComponent;
  let fixture: ComponentFixture<LoHangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoHangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoHangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
