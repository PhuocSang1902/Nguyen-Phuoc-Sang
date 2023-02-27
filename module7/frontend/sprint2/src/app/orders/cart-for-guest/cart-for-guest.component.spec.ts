import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartForGuestComponent } from './cart-for-guest.component';

describe('CartForGuestComponent', () => {
  let component: CartForGuestComponent;
  let fixture: ComponentFixture<CartForGuestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CartForGuestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CartForGuestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
