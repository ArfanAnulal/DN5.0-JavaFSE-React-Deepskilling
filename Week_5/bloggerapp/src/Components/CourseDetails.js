import React from 'react';

const coursesData = [
  { id: 301, name: 'Full Stack Java & React Deepskilling', instructor: 'Cognizant Academy', duration: '8 Weeks' },
  { id: 302, name: 'Cloud Native Microservices Architecture', instructor: 'Spring & AWS Team', duration: '6 Weeks' },
  { id: 303, name: 'Modern DevOps & Kubernetes Mastery', instructor: 'DevOps Lead', duration: '5 Weeks' }
];

const CourseDetails = () => {
  return (
    <div className="section-card course-section">
      <h2>🎓 Course Details Directory</h2>
      <div className="card-list">
        {coursesData.map(course => (
          <div key={course.id} className="item-card">
            <h4>{course.name}</h4>
            <p><strong>Instructor:</strong> {course.instructor}</p>
            <p><strong>Duration:</strong> {course.duration}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CourseDetails;
