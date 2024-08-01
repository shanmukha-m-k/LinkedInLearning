import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewListingsComponent } from './new-listings.component';

describe('NewListingsComponent', () => {
  let component: NewListingsComponent;
  let fixture: ComponentFixture<NewListingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewListingsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewListingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
