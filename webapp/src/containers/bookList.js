import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import BookListItem from '../components/bookListItem';
import { selectBook, fetchBooks } from '../actions/index';

class Booklist extends Component {
  constructor(props) {
    super(props);

    this.state = {
      books: [],
      isLoading: false,
    }
  }

  componentDidMount() {
    this.state.isLoading = true;
    fetch('http://localhost:8080/books')
    .then(response => response.json())
    .then(data => this.setState({books: data, isLoading: false }));
  }

  renderList() { return <span>work</span>;}
    // return this.props.fetchBooks.map(book => (
    //   <li key={book.title}>
    //     <BookListItem book={book} onSelectBook={this.props.selectBook} />
    //   </li>
    // ));
  // }

  render() {
    return <ul>{this.renderList()}</ul>;
  }
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators({ selectBook, fetchBooks }, dispatch);
}

export default connect(null, mapDispatchToProps)(Booklist);
