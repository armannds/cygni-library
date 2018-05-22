<template>
  <div>
    <ul>
      <li v-on:click="show(book)" v-bind:key="book.id" v-for="book in books">{{ book.name + ": " + book.author }}</li>    
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
    show: function(book){
      console.log(book.name)
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
li {
  padding: 30px;
  background-color: #f4f4f4;
  display: inline-block;
  margin: 10px;
  text-align: left;
}
</style>
