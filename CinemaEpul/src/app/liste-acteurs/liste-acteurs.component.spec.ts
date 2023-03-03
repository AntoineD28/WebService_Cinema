import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeActeursComponent } from './liste-acteurs.component';

describe('ListeActeursComponent', () => {
  let component: ListeActeursComponent;
  let fixture: ComponentFixture<ListeActeursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeActeursComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeActeursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
