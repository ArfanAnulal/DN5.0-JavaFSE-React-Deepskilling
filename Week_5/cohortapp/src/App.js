import React from 'react';
import './App.css';
import CohortDetails from './Components/CohortDetails';

const cohortsData = [
  { id: 1, title: 'INTADM21QE002', status: 'ongoing', track: 'Java FSE', startDate: '2026-06-01' },
  { id: 2, title: 'INTADM21QE003', status: 'completed', track: '.NET Core', startDate: '2026-03-15' },
  { id: 3, title: 'INTADM21QE004', status: 'ongoing', track: 'Cloud Native', startDate: '2026-05-10' }
];

function App() {
  return (
    <div className="App">
      <h2>My Academy - Ongoing and Completed Cohorts</h2>
      <div className="cohorts-list">
        {cohortsData.map(cohort => (
          <CohortDetails key={cohort.id} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
