import axios from 'axios';

export const BOOK_SELECTED = 'BOOK_SELECTED';
export const FETCH_BOOKS = 'FETCH_BOOKS';


export function selectBook(book) {
  return {
    type: BOOK_SELECTED,
    payload: book,
  };
}

export function fetchBooks() {
  const URL = 'http://localhost:8080/books';
  const request = axios.get(URL);
  return {
    type: FETCH_BOOKS,
    payload: request,
  };
}

