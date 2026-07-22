import { CreditLabelPipe } from './credit-label-pipe';

describe('CreditLabelPipe', () => {
  let pipe: CreditLabelPipe;

  beforeEach(() => {
    pipe = new CreditLabelPipe();
  });

  it('should transform 1 to "1 Credit"', () => {
    expect(pipe.transform(1)).toBe('1 Credit');
  });

  it('should transform 4 to "4 Credits"', () => {
    expect(pipe.transform(4)).toBe('4 Credits');
  });

  it('should transform null/0 to "No Credits"', () => {
    expect(pipe.transform(0)).toBe('No Credits');
    expect(pipe.transform(null)).toBe('No Credits');
  });
});
