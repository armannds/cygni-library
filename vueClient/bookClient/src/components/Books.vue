<template>
  <div id="container">
    <h2>List of all books</h2>
    <div id="filterDiv" >
      <label for="filter">Show only available books</label>
      <input v-model="filterEnabled" id="filter" type="checkbox" />
    </div>
    <ul v-on:delete-book="filterEnabled = !filterEnabled" >
      <li v-if="book.available || !filterEnabled" v-on:click="toogleEdit(book)" v-bind:class="{unavailable: !book.available}" v-bind:key="book.id" v-for="book in books">
        <BookSummary v-bind:book="book" />
        <EditBook v-if="idToEdit === book.id" v-bind:book="book"/> 
        <svg v-on:click="deleteBook(book.id)" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-trash-2"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" x2="10" y1="11" y2="17"></line><line x1="14" x2="14" y1="11" y2="17"></line></svg>
  
      </li> 
    </ul>
  </div>
</template>

<script>
import EditBook from "./EditBook";
import BookSummary from "./BookSummary";

export default {
  components: {
    EditBook,
    BookSummary
  },
  data() {
    return {
      books: [],
      filterEnabled: false,
      idToEdit: ""
    };
  },
  methods: {
    toogleEdit: function(book) {
      if (this.idToEdit == book.id) {
        // this.idToEdit = ""  // won't work due to click through
      } else {
        this.idToEdit = book.id
      }
    },
    toogle: function(book) {
      console.log(book);
      var request = { id: book.id, available: !book.available };
      this.$http
        .put("http://localhost:8443/availabilityStatus", request)
        .then(response => {
          if (response.ok) {
            book.available = response.data.available;
          }
        });
    },
    reloadBooks: function() {
      console.log("loading books");
      this.$http.get("http://localhost:8443/books").then(response => {
        if (response.ok) {
          this.books = response.data;
          this.books.map(it => {
            it.edit = false
            it.available = it.availableCopies > 0
            });
        } else {
          console.log(response);
        }
      });
    },
    deleteBook: function(book) {
      console.log("Deleting: " + book);
      this.$http
        .delete("http://localhost:8443/book/" + book)
        .then(response => {
          if (response.ok) {
            console.log("book deleted");
          }
        })
        .then(e => {
          this.reloadBooks();
        });
    }
  },
  created: function() {
    this.books.push({ id: 1, name: "No books", author: "Sample Author" });
    this.$on('reload-books', this.reloadBooks)
    this.reloadBooks();
  }
};
</script>
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}

p:first-child {
  font-size: large;
}

p {
  padding: 0;
  margin: 0;
  font-size: medium;
}

li {
  padding: 30px;
  background-color: #f0faf0;
  display: inline-block;
  margin: 10px;
  text-align: center;
  padding-bottom: 10px;
}

li:hover {
  transform: scale(1.05);
}

li.unavailable {
  background-color: #faf0f0;
}

li.unavailable div p {
  text-decoration: line-through;
}

#filterDiv {
  margin-left: 60px;
  text-align: left;
}

svg:hover {
  cursor: pointer;
  /* Start the shake animation and make the animation last for 0.5 seconds */
  animation: shake 0.5s;
  /* When the animation is finished, start again */
  animation-iteration-count: initial;
}

@keyframes shake {
  0% {
    transform: translate(1px, 1px) rotate(0deg);
  }
  10% {
    transform: translate(-1px, -2px) rotate(-1deg);
  }
  20% {
    transform: translate(-3px, 0px) rotate(1deg);
  }
  30% {
    transform: translate(3px, 2px) rotate(0deg);
  }
  40% {
    transform: translate(1px, -1px) rotate(1deg);
  }
  50% {
    transform: translate(-1px, 2px) rotate(-1deg);
  }
  60% {
    transform: translate(-3px, 1px) rotate(0deg);
  }
  70% {
    transform: translate(3px, 1px) rotate(-1deg);
  }
  80% {
    transform: translate(-1px, -1px) rotate(1deg);
  }
  90% {
    transform: translate(1px, 2px) rotate(0deg);
  }
  100% {
    transform: translate(1px, -2px) rotate(-1deg);
  }
}

svg {
  width: 30px;
  margin: 10px;
}
</style>
