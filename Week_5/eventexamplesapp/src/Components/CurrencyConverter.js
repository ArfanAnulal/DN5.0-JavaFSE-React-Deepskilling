import React, { Component } from 'react';

class CurrencyConverter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      inrAmount: '',
      euroAmount: 0
    };
  }

  handleInputChange = (event) => {
    this.setState({ inrAmount: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const inrVal = parseFloat(this.state.inrAmount);
    if (isNaN(inrVal) || inrVal < 0) {
      alert('Please enter a valid INR amount.');
      return;
    }
    // Conversion rate: 1 Euro ≈ 90 INR (0.011 multiplier)
    const convertedEuro = (inrVal * 0.011).toFixed(2);
    this.setState({ euroAmount: convertedEuro });
  };

  render() {
    return (
      <div className="converter-card">
        <h2>Currency Converter (INR to EUR)</h2>
        <form onSubmit={this.handleSubmit} className="converter-form">
          <div className="form-group">
            <label htmlFor="inrInput">Amount in INR (₹):</label>
            <input
              id="inrInput"
              type="number"
              value={this.state.inrAmount}
              onChange={this.handleInputChange}
              placeholder="Enter INR amount"
              className="form-input"
              required
            />
          </div>
          <button type="submit" className="convert-btn">Convert Currency</button>
        </form>
        {this.state.euroAmount > 0 && (
          <div className="conversion-result">
            <p><strong>Converted Amount:</strong> €{this.state.euroAmount} EUR</p>
          </div>
        )}
      </div>
    );
  }
}

export default CurrencyConverter;
