export default {
  async registerCoach(context, payload) {
    const coachData = {
      id: context.rootGetters.userId,
      ...payload,
    };

    const token = context.rootGetters.token;
    const userId = context.rootGetters.userId;

    const response = await fetch(
      `https://vue-http-demo-b1c68-default-rtdb.asia-southeast1.firebasedatabase.app/coaches/${userId}.json?auth=${token}`,
      {
        method: 'PUT',
        body: JSON.stringify(coachData),
      }
    );

    if (!response.ok) {
      const error = new Error(response.message || 'Failed to fetch!');
      throw error;
    }

    context.commit('registerCoach', { ...coachData });
  },
  async loadCoaches(context, payload) {
    if (!context.getters.shouldUpdate && !payload.forceRefresh) {
      return;
    }
    const response = await fetch(
      `https://vue-http-demo-b1c68-default-rtdb.asia-southeast1.firebasedatabase.app/coaches.json`
    );

    const responseData = await response.json();

    if (!response.ok) {
      const error = new Error(responseData.message || 'Failed to fetch!');
      throw error;
    }

    const coaches = [];

    for (const key in responseData) {
      const coach = {
        id: key,
        firstName: responseData[key].firstName,
        lastName: responseData[key].lastName,
        description: responseData[key].description,
        hourlyRate: responseData[key].hourlyRate,
        areas: responseData[key].areas,
      };
      coaches.push(coach);
    }

    context.commit('setCoaches', coaches);
    context.commit('setFetchTimestamp');
  },
};
