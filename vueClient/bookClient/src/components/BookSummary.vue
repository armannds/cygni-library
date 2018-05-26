<template>
  <div>
      <p v-bind:class="{unavailable: !book.available}">{{book.name + ' #' + book.availableCopies}}</p>
      <p v-bind:class="{unavailable: !book.available}">{{book.author}}</p>
  </div>
</template>

<script>
export default {
  props: ["book"],
  data() {
    return {};
  },
  methods: {},
  created: function() {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.unavailable {
  text-decoration: line-through;
}
</style>
