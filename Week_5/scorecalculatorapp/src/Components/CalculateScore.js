import React from 'react';
import '../Stylesheets/mystyle.css';

const calcAverage = (totalMarks, subjectsCount = 4) => {
  return (totalMarks / subjectsCount).toFixed(2);
};

const CalculateScore = ({ Name, School, Total, goal }) => {
  const scoreAverage = calcAverage(Total);

  return (
    <div className="score-card-container">
      <h2 className="score-header">Student Performance Report</h2>
      <div className="score-details">
        <p><span className="detail-label">Name:</span> <span>{Name}</span></p>
        <p><span className="detail-label">School:</span> <span>{School}</span></p>
        <p><span className="detail-label">Total:</span> <span>{Total}</span></p>
        <p><span className="detail-label">Goal:</span> <span>{goal}</span></p>
        <p className="highlight-average">
          <span className="detail-label">Average:</span> <span>{scoreAverage}</span>
        </p>
      </div>
    </div>
  );
};

export default CalculateScore;
