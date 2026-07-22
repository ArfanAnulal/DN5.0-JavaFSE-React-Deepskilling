import React, { Component } from 'react';
import './App.css';
import CurrencyConverter from './Components/CurrencyConverter';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
  }

  // Method 1: Increment Counter
  incrementCounter = () => {
    this.setState(prevState => ({ counter: prevState.counter + 1 }));
  };

  // Method 2: Say Hello Message
  sayHello = () => {
    alert('Hello! Welcome to React Synthetic Event Handling.');
  };

  // Multiple methods invocation handler
  handleIncreaseClick = () => {
    this.incrementCounter();
    this.sayHello();
  };

  // Decrement Counter
  decrementCounter = () => {
    this.setState(prevState => ({ counter: prevState.counter - 1 }));
  };

  // Function accepting custom parameter
  sayWelcome = (greeting) => {
    alert(`Greeting Message: ${greeting}`);
  };

  // Synthetic event handler
  handlePressSynthetic = (event) => {
    alert(`Synthetic Event [${event.type}] Triggered! Message: I was clicked`);
  };

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1>React Event Handling Demonstration</h1>
        </header>

        <main className="container">
          <section className="event-section">
            <h2>Counter & Event Handlers</h2>
            <h3 className="counter-display">Current Count: {this.state.counter}</h3>
            
            <div className="button-group">
              <button className="btn btn-primary" onClick={this.handleIncreaseClick}>
                Increment (Multiple Methods)
              </button>
              <button className="btn btn-secondary" onClick={this.decrementCounter}>
                Decrement
              </button>
            </div>

            <div className="button-group">
              <button className="btn btn-info" onClick={() => this.sayWelcome('welcome')}>
                Say Welcome
              </button>
              <button className="btn btn-warning" onClick={this.handlePressSynthetic}>
                OnPress (Synthetic Event)
              </button>
            </div>
          </section>

          <hr className="divider" />

          <section className="converter-section">
            <CurrencyConverter />
          </section>
        </main>
      </div>
    );
  }
}

export default App;
