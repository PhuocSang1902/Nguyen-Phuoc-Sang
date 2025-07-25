export default {
  registerCoach(context, payload) {
    const coachData = {
      id: context.rootGetters.userId,
      ...payload,
    };
    context.commit('registerCoach', coachData);
  },
};
