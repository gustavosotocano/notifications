import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListpaginationComponent } from './listpagination.component';

describe('ListpaginationComponent', () => {
  let component: ListpaginationComponent;
  let fixture: ComponentFixture<ListpaginationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListpaginationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListpaginationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
