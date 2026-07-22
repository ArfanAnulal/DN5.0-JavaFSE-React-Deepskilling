import React from 'react';
import './App.css';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

const App = () => {
  return (
    <div className="App">
      <header className="App-header">
        <h2>Student Management Portal</h2>
      </header>
      <main className="content-container">
        <Home />
        <About />
        <Contact />
      </main>
    </div>
  );
};

export default App;
