<template>
  <div>
    <base-dialog
      :show="!!error"
      title="An error occurred!"
      @close="handleError"
    >
      <p>{{ error }}</p>
    </base-dialog>
    <base-dialog :show="isLoading" title="Authenticating..." fixed>
      <base-spinner />
    </base-dialog>

    <base-card>
      <form @submit.prevent="handleSubmit">
        <div class="form-control">
          <label for="email">Your E-Mail</label>
          <input type="email" id="email" v-model="email" />
        </div>
        <div class="form-control">
          <label for="password">Your Password</label>
          <input type="password" id="password" v-model="password" />
        </div>
        <p v-if="!formIsValid">Please enter a valid email and password</p>
        <base-button>{{ submitButtonCaption }}</base-button>
        <base-button type="button" mode="flat" @click="switchAuthMode">{{
          switchModeButtonCaption
        }}</base-button>
      </form>
    </base-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: '',
      password: '',
      formIsValid: true,
      mode: 'login',
      loading: false,
      error: null,
    };
  },
  computed: {
    submitButtonCaption() {
      return this.mode === 'login' ? 'Login' : 'Signup';
    },
    switchModeButtonCaption() {
      return this.mode === 'login' ? 'Signup instead' : 'Login instead';
    },
    isLoading() {
      return this.loading;
    },
  },
  methods: {
    async handleSubmit() {
      this.formIsValid = true;
      if (
        this.email === '' ||
        !this.email.includes('@') ||
        this.password === '' ||
        this.password.length < 6
      ) {
        this.formIsValid = false;
        return;
      }
      this.loading = true;

      const actionPayload = {
        email: this.email,
        password: this.password,
      };

      try {
        if (this.mode === 'login') {
          await this.$store.dispatch('login', actionPayload);
        } else {
          await this.$store.dispatch('signup', actionPayload);
        }
        const redirectUrl = '/' + (this.$route.query.redirect || 'coaches');
        this.$router.replace(redirectUrl);
      } catch (err) {
        this.error = err.message || 'Failed to authenticate.';
      }
      this.loading = false;
    },
    switchAuthMode() {
      this.mode = this.mode === 'login' ? 'signup' : 'login';
    },
    handleError() {
      this.error = null;
    },
  },
};
</script>

<style scoped>
form {
  margin: 1rem;
  padding: 1rem;
}

.form-control {
  margin: 0.5rem 0;
}

label {
  font-weight: bold;
  margin-bottom: 0.5rem;
  display: block;
}

input,
textarea {
  display: block;
  width: 100%;
  font: inherit;
  border: 1px solid #ccc;
  padding: 0.15rem;
}

input:focus,
textarea:focus {
  border-color: #3d008d;
  background-color: #faf6ff;
  outline: none;
}
</style>
