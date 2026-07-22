import React from 'react';

const Greeting = ({ isLoggedIn }) => {
  if (isLoggedIn) {
    return <h3 className="greeting-text user-greeting">Welcome back, Registered User!</h3>;
  }
  return <h3 className="greeting-text guest-greeting">Welcome, Guest! Browsing Mode</h3>;
};

export default Greeting;
