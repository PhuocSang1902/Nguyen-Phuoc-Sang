<template>
  <section>
    <base-card>
      <h2>Register as a Coach</h2>
      <coach-form @save-data="saveData"></coach-form>
    </base-card>
  </section>
</template>

<script>
import CoachForm from '@/components/coaches/CoachForm.vue';

export default {
  components: {
    CoachForm,
  },
  computed: {
    isCoach() {
      return this.$store.getters['coaches/isCoach'];
    },
  }, 
  data() {
    return {
      firstName: '',
      lastName: '',
      description: '',
      hourlyRate: null,
    };
  },
  methods: {
    saveData(data) {
      this.$store.dispatch('coaches/registerCoach', data);
      this.$router.replace('/coaches');
    },
  },
};
</script>

<style scoped>

</style>
