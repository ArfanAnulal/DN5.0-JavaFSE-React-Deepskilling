import { Directive, ElementRef, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: false
})
export class Highlight {
  // Configurable highlight color via @Input property binding
  @Input() appHighlight: string = 'yellow';

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  @HostListener('mouseenter') onMouseEnter(): void {
    this.setBgColor(this.appHighlight || '#fef08a');
  }

  @HostListener('mouseleave') onMouseLeave(): void {
    this.setBgColor(null);
  }

  private setBgColor(color: string | null): void {
    this.renderer.setStyle(this.el.nativeElement, 'backgroundColor', color);
    this.renderer.setStyle(this.el.nativeElement, 'transition', 'background-color 0.2s ease');
  }
}
