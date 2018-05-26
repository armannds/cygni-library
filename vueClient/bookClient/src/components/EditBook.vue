<template>
  <div class="summary">
      <ul>
        <li v-for="person in reservedBy" 
            v-bind:key="person.id" 
            v-bind:class="{unReserve: person.unReserve}"
            v-on:click="toggleReserve(person)" >
                {{person.name}}
        </li>
      </ul>
      <div v-if="book.available">
      <label for="reserveName">Reserve book: </label>
      <input id="reserveName" v-model="reserveName" placeholder="Your name" />
      <input type="button" v-on:click="reserve()" value="reserve" />
      </div>

  </div>
</template>

<script>
export default {
  props: {
    book: Object
  },
  data() {
    return {
      reserveName: "",
      reservedBy: []
    };
  },
  methods: {
    toggleReserve: function(person) {
      person.unReserve = !person.unReserve;
    },
    reserve: function() {
      let request = {
        name: this.reserveName,
        id: this.book.id,
        unReserve: false
      };
      this.$http
        .put("http://localhost:8443/book/reserve", request)
        .then(response => {
          if (response.ok) {
            this.reserveName = "";
            this.$parent.$emit('reload-books')
          } else {
            console.log(response);
          }
        });
    }
  },
  created: function() {
    this.book.reservedBy.map((username, index) => {
      this.reservedBy.push({
        name: username,
        id: index,
        unReserve: false
      });
    });

    //addUser(this, Math.floor(Math.random() * 5));
  }
};

function addUser(vm, nUsers) {
  vm.$http
    .get("https://randomuser.me/api?inc=name&nat=DK&results=" + nUsers)
    .then(response => {
      if (response.ok) {
        for (let i = 0; i < nUsers; i++) {
          let name = response.data.results[i].name.first;
          vm.reservedBy.push({
            id: vm.reservedBy.length + 23,
            name: name,
            unReserve: false
          });
        }
      } else {
        console.log(response);
      }
    });
}
</script>

<style scoped>
.unReserve {
  text-decoration: line-through;
  animation: shake 0.8s;
  animation-iteration-count: initial;
}
div {
  text-align: left;
}
table {
  width: 100%;
}

input {
  width: 100%;
}

td:first-child {
  white-space: nowrap;
}

li::first-letter {
  text-transform: capitalize;
}

li {
  cursor: pointer;
}

@keyframes shake {
  0% {
    transform: translate(0px, 0px) rotate(0deg);
  }
  50% {
    transform: translate(3px, 0px) rotate(-2deg);
  }
}
</style>
