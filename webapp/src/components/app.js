import React from 'react';
import BookList from '../containers/bookList';
import BookDetail from '../containers/bookDetail';

const App = () => (
  <div className="columns">
    <div className="column is-one-third">
      <BookList />
    </div>
    <div className="column">
      <BookDetail />
    </div>
  </div>
);

export default App;
