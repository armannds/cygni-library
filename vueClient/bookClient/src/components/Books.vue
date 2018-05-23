<template>
  <div>
    <ul>
      <li v-on:click="toogle(book)" v-bind:class="{unavailable: !book.available}" v-bind:key="book.id" v-for="book in books">
        <p>{{book.name}}</p>
        <p>{{book.author }}</p>
        <input type="button" value ="X" v-on:click="deleteBook(book)">
        </li>    
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      books: []
    }
  },
  methods: {
    toogle: function(book){
      console.log(book)
      var request = {id: book.id, available:!book.available}
      this.$http.put('http://localhost:8443/availabilityStatus', request).
        then( response => {
          if (response.ok) {
            book.available = response.data.available
          }
        })
    },
    deleteBook : function(book) {
      console.log("Deleting" + book.id)
      this.$http.delete('http://localhost:8443/book/' + book.id).
        then(response => {
          if (response.ok){
            console.log("book deleted")

            var index = this.books.map(function(it) {return it.id}).indexOf(book.id);
            if (index > -1) {
              this.books.splice(index, 1)
            }
          }
        })
    }
  },
  created: function() {
    this.books.push(
      {id:1, name:"Mamma Mu", author:"Mia"},
      {id:2, name:"Mias Bil", author:"Kalle"}
      )

      this.$http.get('http://localhost:8443/books').
        then(response => {
          if (response.ok) {
            this.books = response.data
          } else {
            console.log(response)
          }
        })
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

p:first-child {
  font-size: large;
}

p {
  padding: 0;
  margin:0;
  font-size: medium;
}

li {
  padding: 30px;
  background-color: #f0faf0;
  display: inline-block;
  margin: 10px;
  text-align: center;
}

.unavailable {
  text-decoration: line-through;
  background-color: #faf0f0
}
</style>
