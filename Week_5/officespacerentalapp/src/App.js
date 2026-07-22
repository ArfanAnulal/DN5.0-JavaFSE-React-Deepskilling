import React from 'react';
import './App.css';
import CohortDetails from './Components/CohortDetails';

const officeSpacesList = [
  { id: 1, name: 'DBS Tech Park', rent: 50000, address: 'OMR, Chennai' },
  { id: 2, name: 'JSB Executive Hub', rent: 65000, address: 'Hitec City, Hyderabad' },
  { id: 3, name: 'KPT Business Center', rent: 55000, address: 'Koramangala, Bangalore' },
  { id: 4, name: 'Regus Prestige Suites', rent: 85000, address: 'BKC, Mumbai' }
];

const sampleSingleOffice = {
  name: 'DBS Tech Park',
  rent: 50000,
  address: 'OMR, Chennai'
};

const cohortsList = [
  { id: 1, title: 'GENAI - Java FSE', status: 'ongoing', track: 'Java & React Deepskilling', startDate: '2026-06-01' },
  { id: 2, title: 'Cloud Native AWS', status: 'completed', track: 'AWS Architecture', startDate: '2026-03-15' },
  { id: 3, title: 'Data Engineering', status: 'ongoing', track: 'Big Data & Spark', startDate: '2026-05-10' }
];

function App() {
  const officeImageSrc = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=800&q=80";

  return (
    <div className="App">
      <header className="main-header">
        <h1>Office Space, at Affordable Range</h1>
      </header>

      <div className="banner-container">
        <img src={officeImageSrc} alt="Modern Office Space" className="office-banner" />
      </div>

      <section className="featured-section">
        <h2>Featured Office Space</h2>
        <div className="office-card single-card">
          <h3>Name: {sampleSingleOffice.name}</h3>
          <h3 style={{ color: sampleSingleOffice.rent < 60000 ? 'red' : 'green' }}>
            Rent: ₹{sampleSingleOffice.rent.toLocaleString()}
          </h3>
          <h3>Address: {sampleSingleOffice.address}</h3>
        </div>
      </section>

      <section className="catalog-section">
        <h2>Available Office Spaces List</h2>
        <div className="office-grid">
          {officeSpacesList.map(item => (
            <div key={item.id} className="office-card">
              <h3>Name: {item.name}</h3>
              <h3 style={{ color: item.rent < 60000 ? 'red' : 'green' }}>
                Rent: ₹{item.rent.toLocaleString()}
              </h3>
              <h3>Address: {item.address}</h3>
            </div>
          ))}
        </div>
      </section>

      <section className="cohorts-section">
        <h2>Cognizant Academy Cohorts</h2>
        <div className="cohorts-container">
          {cohortsList.map(cohort => (
            <CohortDetails key={cohort.id} cohort={cohort} />
          ))}
        </div>
      </section>
    </div>
  );
}

export default App;
