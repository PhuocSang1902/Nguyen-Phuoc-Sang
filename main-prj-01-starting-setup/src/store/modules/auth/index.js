import mutations from './mutations.js';
import actions from './actions.js';
import getters from './getters.js';

export default {
  namespaced: true,
  state() {
    return {
      userId: 'u1',
      token: 't1',
    };
  },
  mutations,
  actions,
  getters,
};
