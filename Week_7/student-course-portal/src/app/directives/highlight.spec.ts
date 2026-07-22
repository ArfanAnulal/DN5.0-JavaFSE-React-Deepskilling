import { Component } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { Highlight } from './highlight';

@Component({
  template: `<div [appHighlight]="'yellow'" id="test-div">Hover me</div>`,
  standalone: false
})
class TestComponent {}

describe('HighlightDirective', () => {
  let fixture: ComponentFixture<TestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Highlight, TestComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(TestComponent);
    fixture.detectChanges();
  });

  it('should apply background color on mouseenter and clear on mouseleave', () => {
    const divDebug = fixture.debugElement.query(By.css('#test-div'));
    
    divDebug.triggerEventHandler('mouseenter', null);
    fixture.detectChanges();
    expect(divDebug.nativeElement.style.backgroundColor).toBeTruthy();

    divDebug.triggerEventHandler('mouseleave', null);
    fixture.detectChanges();
    expect(divDebug.nativeElement.style.backgroundColor).toBe('');
  });
});
