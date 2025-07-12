<template>
  <div>
    <h2>Manage Goals</h2>
    <input type="text" placeholder="Goal" ref="goal" />
    <button @click="addGoal">Add Goal</button>
    <teleport to="body">
      <error-alert v-if="inputIsInvalid">
        <h2>Invalid Input</h2>
        <p>Please enter a valid goal</p>
        <button @click="confirmError">Okay</button>
      </error-alert>
    </teleport>
  </div>
</template>

<script>
import ErrorAlert from './ErrorAlert.vue';

export default {
  data() {
    return {
      inputIsInvalid: false,
    };
  },
  components: {
    ErrorAlert,
  },
  methods: {
    addGoal() {
      const enteredValue = this.$refs.goal.value;
      if (enteredValue === '') {
        this.inputIsInvalid = true;
      }
    },
    confirmError() {
      this.inputIsInvalid = false;
    },
  },
};
</script>
