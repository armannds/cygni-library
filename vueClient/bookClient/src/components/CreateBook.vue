<template>
  <div>
    <h2> Create new Book</h2>
      <label for="BookTitle">Book title: </label>
      <input id="BookTitle" v-model="book.name" placeholder="Book Title" />
      <label for="BookAuthor">Author name: </label>
      <input id="BookAuthor" v-model="book.author" placeholder="Author Name" />
      <label for="BookCopies">#Copies</label> 
      <input id="BookCopies" v-model="book.availableCopies" type="number">
      <input type="button" value="Create" v-on:click="createBook(book)"/>

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      book: {
        name: "",
        author: "",
        availableCopies: 1
      }
    }
  },
  methods: {
      createBook: function(book) {
        this.$http.put('http://localhost:8443/book', book).
          then(response => {
            if (response.ok){
              console.log('Book added')
              book.name = ""
              book.author = ""
              location.reload() // TODO: How should it be done :/
            } else {
              console.log(response)
            }
          })
      }
  },
  created: function() {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
div {
  margin-bottom: 60px;
}
li {
  padding: 30px;
  background-color: #f4f4f4;
  display: inline-block;
  margin: 10px;
  text-align: left;
}

</style>
