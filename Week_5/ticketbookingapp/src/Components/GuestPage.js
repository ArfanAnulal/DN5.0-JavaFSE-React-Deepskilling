import React from 'react';

const flightsData = [
  { id: 'AI101', airline: 'Air India', origin: 'Delhi', destination: 'Mumbai', departure: '06:00 AM', fare: 5200 },
  { id: '6E205', airline: 'IndiGo', origin: 'Bangalore', destination: 'Chennai', departure: '09:30 AM', fare: 3400 },
  { id: 'SG308', airline: 'SpiceJet', origin: 'Mumbai', destination: 'Kolkata', departure: '02:15 PM', fare: 4800 }
];

const GuestPage = () => {
  return (
    <div className="page-container guest-view">
      <h2>Guest Browse Portal</h2>
      <p className="info-msg">Please log in to your account to book flight tickets.</p>
      <div className="flights-list">
        {flightsData.map(flight => (
          <div key={flight.id} className="flight-item">
            <div className="flight-info">
              <span className="flight-code">{flight.id} ({flight.airline})</span>
              <span className="flight-route">{flight.origin} → {flight.destination} ({flight.departure})</span>
            </div>
            <span className="flight-fare">₹{flight.fare}</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default GuestPage;
