import React, { useState } from 'react';
import './App.css';
import GuestPage from './Components/GuestPage';
import UserPage from './Components/UserPage';
import Greeting from './Components/Greeting';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  // Element Variable Conditional Rendering Demonstration
  let mainContent;
  let authButton;

  if (isLoggedIn) {
    mainContent = <UserPage />;
    authButton = (
      <button className="auth-btn logout-btn" onClick={handleLogoutClick}>
        Logout
      </button>
    );
  } else {
    mainContent = <GuestPage />;
    authButton = (
      <button className="auth-btn login-btn" onClick={handleLoginClick}>
        Login
      </button>
    );
  }

  return (
    <div className="App">
      <header className="App-header">
        <h1>Flight Ticket Booking Portal</h1>
        <div className="header-actions">
          <Greeting isLoggedIn={isLoggedIn} />
          {authButton}
        </div>
      </header>

      <main className="App-main">
        {mainContent}
      </main>
    </div>
  );
}

export default App;
