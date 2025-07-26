export default {
  login(context, payload) {
    context.commit('setUser', {
      userId: payload.userId,
      token: payload.token,
    });
  },
  signup(context, payload) {
    context.commit('setUser', {
      userId: payload.userId,
      token: payload.token,
    });
  },
};
