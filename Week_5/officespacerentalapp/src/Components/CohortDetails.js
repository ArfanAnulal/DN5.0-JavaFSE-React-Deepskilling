import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohort }) => {
  const { title, status, track, startDate } = cohort;
  const headingColor = status.toLowerCase() === 'ongoing' ? 'green' : 'blue';

  return (
    <div className={styles.box}>
      <h3 style={{ color: headingColor }}>
        {title} ({status})
      </h3>
      <dl>
        <dt>Track / Technology:</dt>
        <dd>{track}</dd>
        <dt>Start Date:</dt>
        <dd>{startDate}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
