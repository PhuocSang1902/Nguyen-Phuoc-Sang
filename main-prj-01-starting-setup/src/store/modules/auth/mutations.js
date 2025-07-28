export default {
  setUser(state, payload) {
    state.userId = payload.userId;
    state.token = payload.token;
    state.didAutoLogout = false;
  },
  didAutoLogout(state) {
    state.didAutoLogout = true;
  },
};
