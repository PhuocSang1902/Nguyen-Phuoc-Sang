import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoHangCreateComponent } from './lo-hang-create.component';

describe('LoHangCreateComponent', () => {
  let component: LoHangCreateComponent;
  let fixture: ComponentFixture<LoHangCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoHangCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoHangCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
