import React from 'react';

export default function () {
  const URL = "https://localhost:8080/books";
  return fetch(URL, { method: 'GET'})
     .then( response => Promise.all([response, response.json()]));
}
