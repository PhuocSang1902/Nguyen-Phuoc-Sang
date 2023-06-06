import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NameCardParentComponent } from './name-card-parent.component';

describe('NameCardParentComponent', () => {
  let component: NameCardParentComponent;
  let fixture: ComponentFixture<NameCardParentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NameCardParentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NameCardParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
