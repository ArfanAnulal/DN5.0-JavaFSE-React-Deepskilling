import React from 'react';

const blogsData = [
  { id: 201, title: 'Understanding React Virtual DOM', author: 'Alex Rivera', readTime: '5 min' },
  { id: 202, title: 'Deep Dive into Conditional Rendering', author: 'Sarah Chen', readTime: '8 min' },
  { id: 203, title: 'State Management Patterns in 2026', author: 'Markus Vance', readTime: '6 min' }
];

const BlogDetails = () => {
  return (
    <div className="section-card blog-section">
      <h2>✍️ Blog Details Directory</h2>
      <div className="card-list">
        {blogsData.map(blog => (
          <div key={blog.id} className="item-card">
            <h4>{blog.title}</h4>
            <p><strong>Author:</strong> {blog.author}</p>
            <p><strong>Read Time:</strong> {blog.readTime}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BlogDetails;
