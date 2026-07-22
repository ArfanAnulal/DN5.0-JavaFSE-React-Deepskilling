import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohort }) => {
  const { title, status, track, startDate } = cohort;
  const statusColor = status.toLowerCase() === 'ongoing' ? 'green' : 'blue';

  return (
    <div className={styles.box}>
      <h3 style={{ color: statusColor }}>
        {title} - {status}
      </h3>
      <dl>
        <dt>Technology Track:</dt>
        <dd>{track}</dd>
        <dt>Start Date:</dt>
        <dd>{startDate}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
