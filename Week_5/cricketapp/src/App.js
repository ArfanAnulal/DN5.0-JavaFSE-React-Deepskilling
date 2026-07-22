import React, { useState } from 'react';
import './App.css';
import ListofPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Indian Cricket Team Dashboard</h1>
        <button className="toggle-btn" onClick={() => setFlag(!flag)}>
          Toggle View (Current Flag: {flag ? 'true' : 'false'})
        </button>
      </header>
      <main className="App-body">
        {flag ? <ListofPlayers /> : <IndianPlayers />}
      </main>
    </div>
  );
}

export default App;
