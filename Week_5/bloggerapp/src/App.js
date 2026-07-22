import React, { useState } from 'react';
import './App.css';
import Header from './Components/Header';
import Footer from './Components/Footer';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  const [selectedView, setSelectedView] = useState('books');
  const [showSummary, setShowSummary] = useState(true);

  // Technique 1: Element Variable with If-Else logic
  let activeComponent;
  if (selectedView === 'books') {
    activeComponent = <BookDetails />;
  } else if (selectedView === 'blogs') {
    activeComponent = <BlogDetails />;
  } else if (selectedView === 'courses') {
    activeComponent = <CourseDetails />;
  } else {
    activeComponent = <p>No category selected.</p>;
  }

  return (
    <div className="App">
      <Header />

      <nav className="tab-navigation">
        <button 
          className={`tab-btn ${selectedView === 'books' ? 'active' : ''}`}
          onClick={() => setSelectedView('books')}
        >
          Book Details
        </button>
        <button 
          className={`tab-btn ${selectedView === 'blogs' ? 'active' : ''}`}
          onClick={() => setSelectedView('blogs')}
        >
          Blog Details
        </button>
        <button 
          className={`tab-btn ${selectedView === 'courses' ? 'active' : ''}`}
          onClick={() => setSelectedView('courses')}
        >
          Course Details
        </button>
      </nav>

      {/* Technique 2: Logical AND (&&) operator */}
      <div className="toggle-bar">
        <label>
          <input 
            type="checkbox" 
            checked={showSummary} 
            onChange={() => setShowSummary(!showSummary)} 
          />
          Show Active Category Banner
        </label>
      </div>

      {showSummary && (
        <div className="info-banner">
          Currently displaying details for: <strong>{selectedView.toUpperCase()}</strong>
        </div>
      )}

      {/* Technique 3: Rendering Element Variable */}
      <main className="main-content">
        {activeComponent}
      </main>

      <Footer />
    </div>
  );
}

export default App;
