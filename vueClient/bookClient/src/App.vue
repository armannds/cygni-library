<template>
  <div id="app">
    <CreateBook />
    <Books/>
  </div>
</template>

<script>

import Books from './components/Books'
import CreateBook from './components/CreateBook'

export default {
  name: 'App',
  components: {
    Books, CreateBook
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
