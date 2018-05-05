import React from 'react';

const BookListItem = ({ book, onSelectBook }) => (
  <div className="card" onClick={() => onSelectBook(book)} role="presentation">
    <div className="card-content">{book.title}</div>
  </div>
);

export default BookListItem;
