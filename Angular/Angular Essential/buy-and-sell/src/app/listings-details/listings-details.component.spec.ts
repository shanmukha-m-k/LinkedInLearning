import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListingsDetailsComponent } from './listings-details.component';

describe('ListingsDetailsComponent', () => {
  let component: ListingsDetailsComponent;
  let fixture: ComponentFixture<ListingsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListingsDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListingsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
