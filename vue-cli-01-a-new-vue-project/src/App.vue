<template>
  <section>
    <h2>My Friends</h2>
    <ul>
      <li v-for="friend in friend" :key="friend.id">{{ friend.name }}</li>
    </ul>
  </section>
</template>

<script>
export default {
  data() {
    return {
      friend: [
        {
          id: 'manuel',
          name: 'Manuel Lorenz',
          phone: '0176 34578901',
          email: 'manuel@localhost.com',
        },
        {
          id: 'julie',
          name: 'Julie Jones',
          phone: '0987 654321',
          email: 'julie@localhost.com',
        },
      ],
    };
  },
};
</script>
