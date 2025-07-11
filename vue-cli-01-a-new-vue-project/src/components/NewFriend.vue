<template>
  <form action="" @submit.prevent="submitForm">
    <div>
      <label for="name">Name</label>
      <input type="text" id="name" placeholder="Name" v-model="enteredName" />
    </div>
    <div>
      <label for="email">Email</label>
      <input
        type="email"
        id="email"
        placeholder="Email"
        v-model="enteredEmail"
      />
    </div>
    <div>
      <label for="phone">Phone</label>
      <input type="tel" id="phone" placeholder="Phone" v-model="enteredPhone" />
    </div>
    <div>
      <button>Add Contact</button>
    </div>
  </form>
</template>

<script>
export default {
  emits: ['add-contact'],
  data() {
    return {
      enteredName: '',
      enteredEmail: '',
      enteredPhone: '',
    };
  },
  methods: {
    submitForm() {
      this.$emit(
        'add-contact',
        this.enteredName,
        this.enteredEmail,
        this.enteredPhone
      );
    },
  },
};
</script>
