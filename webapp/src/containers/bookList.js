import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import BookListItem from '../components/bookListItem';
import selectBook from '../actions/index';

class Booklist extends Component {
  renderList() {
    return this.props.books.map(book => (
      <li key={book.title}>
        <BookListItem book={book} onSelectBook={this.props.selectBook} />
      </li>
    ));
  }

  render() {
    return <ul>{this.renderList()}</ul>;
  }
}

function mapStateToProps(state) {
  return {
    books: state.books,
  };
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators({ selectBook }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(Booklist);
