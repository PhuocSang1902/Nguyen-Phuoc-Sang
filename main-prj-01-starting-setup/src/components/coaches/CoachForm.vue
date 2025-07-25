<template>
  <form @submit.prevent="saveData">
    <div class="form-control" :class="{ invalid: !firstName.isValid }">
      <label for="first-name">First Name</label>
      <input
        type="text"
        id="first-name"
        v-model="firstName.value"
        @blur="clearValidity('firstName')"
      />
      <p v-if="!firstName.isValid">First name must not be empty.</p>
    </div>
    <div class="form-control" :class="{ invalid: !lastName.isValid }">
      <label for="last-name">Last Name</label>
      <input
        type="text"
        id="last-name"
        v-model="lastName.value"
        @blur="clearValidity('lastName')"
      />
      <p v-if="!lastName.isValid">Last name must not be empty.</p>
    </div>
    <div class="form-control" :class="{ invalid: !description.isValid }">
      <label for="description">Description</label>
      <textarea
        id="description"
        rows="5"
        v-model="description.value"
        @blur="clearValidity('description')"
      ></textarea>
      <p v-if="!description.isValid">Description must not be empty.</p>
    </div>
    <div class="form-control" :class="{ invalid: !hourlyRate.isValid }">
      <label for="rate">Hourly Rate (EUR)</label>
      <input
        type="number"
        id="rate"
        v-model.number="hourlyRate.value"
        @blur="clearValidity('hourlyRate')"
      />
      <p v-if="!hourlyRate.isValid">Hourly rate must be greater than 0.</p>
    </div>
    <div class="form-control" :class="{ invalid: !areas.isValid }">
      <h3>Areas of Expertise</h3>
      <div>
        <input
          type="checkbox"
          id="frontend"
          value="frontend"
          v-model="areas.value"
          @blur="clearValidity('areas')"
        />
        <label for="frontend">Frontend</label>
      </div>
      <div>
        <input
          type="checkbox"
          id="backend"
          value="backend"
          v-model="areas.value"
          @blur="clearValidity('areas')"
        />
        <label for="backend">Backend</label>
      </div>
      <div>
        <input
          type="checkbox"
          id="career"
          value="career"
          v-model="areas.value"
          @blur="clearValidity('areas')"
        />
        <label for="career">Career</label>
      </div>
      <p v-if="!areas.isValid">
        At least one area of expertise must be selected.
      </p>
    </div>
    <p v-if="!formIsValid">Please fix the above errors and submit again.</p>
    <base-button type="submit">Register</base-button>
  </form>
</template>

<script>
export default {
  emits: ['save-data'],
  data() {
    return {
      firstName: {
        value: '',
        isValid: true,
      },
      lastName: {
        value: '',
        isValid: true,
      },
      description: {
        value: '',
        isValid: true,
      },
      hourlyRate: {
        value: null,
        isValid: true,
      },
      areas: {
        value: [],
        isValid: true,
      },
      formIsValid: true,
    };
  },
  methods: {
    clearValidity(input) {
      this[input].isValid = true;
    },
    validateForm() {
      this.formIsValid = true;
      if (this.firstName.value === '') {
        this.firstName.isValid = false;
        this.formIsValid = false;
      }
      if (this.lastName.value === '') {
        this.lastName.isValid = false;
        this.formIsValid = false;
      }
      if (this.description.value === '') {
        this.description.isValid = false;
        this.formIsValid = false;
      }
      if (!this.hourlyRate.value || this.hourlyRate.value < 0) {
        this.hourlyRate.isValid = false;
        this.formIsValid = false;
      }
      if (this.areas.value.length === 0) {
        this.areas.isValid = false;
        this.formIsValid = false;
      }
    },
    saveData() {
      this.validateForm();
      if (!this.formIsValid) {
        return;
      }

      const formData = {
        firstName: this.firstName.value,
        lastName: this.lastName.value,
        description: this.description.value,
        hourlyRate: this.hourlyRate.value,
        areas: this.areas.value,
      };

      this.$emit('save-data', formData);
    },
  },
};
</script>

<style scoped>
form {
  margin: 0.5rem 0;
}

label {
  font-weight: bold;
  display: block;
  margin-bottom: 0.5rem;
}

input[type='checkbox'] + label {
  font-weight: normal;
  margin-left: 0 0 0 0.5rem;
  display: inline;
}

input,
textarea {
  display: block;
  width: 100%;
  font: inherit;
  border: 1px solid #ccc;
}

input:focus,
textarea:focus {
  outline: none;
  border-color: #3d008d;
  background-color: #f0e6fd;
}

input[type='checkbox'] {
  display: inline;
  width: auto;
  border: none;
}

input[type='checkbox']:focus {
  outline: #3d008d solid 1px;
}

h3 {
  margin: 0.5rem 0;
  font-size: 1rem;
}

.invalid label {
  color: red;
}

.invalid input,
.invalid textarea {
  border: 1px solid red;
}
</style>
