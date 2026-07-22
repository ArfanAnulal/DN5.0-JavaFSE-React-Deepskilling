import React from 'react';

const flightsData = [
  { id: 'AI101', airline: 'Air India', origin: 'Delhi', destination: 'Mumbai', departure: '06:00 AM', fare: 5200 },
  { id: '6E205', airline: 'IndiGo', origin: 'Bangalore', destination: 'Chennai', departure: '09:30 AM', fare: 3400 },
  { id: 'SG308', airline: 'SpiceJet', origin: 'Mumbai', destination: 'Kolkata', departure: '02:15 PM', fare: 4800 }
];

const UserPage = () => {
  const handleBook = (flightId) => {
    alert(`Ticket successfully booked for Flight ${flightId}!`);
  };

  return (
    <div className="page-container user-view">
      <h2>User Ticket Booking Dashboard</h2>
      <p className="success-msg">Welcome Back! Select a flight to complete your reservation.</p>
      <div className="flights-list">
        {flightsData.map(flight => (
          <div key={flight.id} className="flight-item">
            <div className="flight-info">
              <span className="flight-code">{flight.id} ({flight.airline})</span>
              <span className="flight-route">{flight.origin} → {flight.destination} ({flight.departure})</span>
            </div>
            <div className="flight-action">
              <span className="flight-fare">₹{flight.fare}</span>
              <button className="book-btn" onClick={() => handleBook(flight.id)}>
                Book Ticket
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserPage;
