<template>
  <button @click="addOne({value: 10})">Add 10</button>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  methods: {
    ...mapActions({
      addOne: 'increase',
    }),
    // addOne() {
    //   // this.$store.commit('increase', { value: 10 });
    //   // this.$store.dispatch('increase', { value: 10 });
    //   this.increase({ value: 10 });
    // },
  },
};
</script>
