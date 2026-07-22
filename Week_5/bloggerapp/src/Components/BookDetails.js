import React from 'react';

const booksData = [
  { id: 101, title: 'Mastering React', author: 'Dan Abramov', price: 499 },
  { id: 102, title: 'Clean Code in JavaScript', author: 'Robert C. Martin', price: 699 },
  { id: 103, title: 'Design Patterns & Systems', author: 'Erich Gamma', price: 850 }
];

const BookDetails = () => {
  return (
    <div className="section-card book-section">
      <h2>📚 Book Details Directory</h2>
      <div className="card-list">
        {booksData.map(book => (
          <div key={book.id} className="item-card">
            <h4>{book.title}</h4>
            <p><strong>Author:</strong> {book.author}</p>
            <p><strong>Price:</strong> ₹{book.price}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BookDetails;
