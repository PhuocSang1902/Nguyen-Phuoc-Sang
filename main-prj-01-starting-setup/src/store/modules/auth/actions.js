export default {
  async login(context, payload) {
    const response = await fetch('https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCN5fFP-RyLsbhT0wa5HbGX4xDgBd-D65I', {
      method: 'POST',
      body: JSON.stringify({
        email: payload.email,
        password: payload.password,
        returnSecureToken: true,
      }),
    });
    const responseData = await response.json();
    if (!response.ok) {
      const error = new Error(responseData.error.message || 'Failed to login.');
      throw error;
    }
    context.commit('setUser', {
      userId: responseData.localId,
      token: responseData.idToken,
      tokenExpiration: responseData.expiresIn,
    });
  },
  async signup(context, payload) {
    const response = await fetch('https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyCN5fFP-RyLsbhT0wa5HbGX4xDgBd-D65I', {
      method: 'POST',
      body: JSON.stringify({
        email: payload.email,
        password: payload.password,
        returnSecureToken: true,
      }),
    });
    const responseData = await response.json();
    if (!response.ok) {
      const error = new Error(responseData.error.message || 'Failed to sign up.');
      throw error;
    }
    context.commit('setUser', {
      userId: responseData.localId,
      token: responseData.idToken,
      tokenExpiration: responseData.expiresIn,
    });
  },
  async logout(context) {
    context.commit('setUser', {
      userId: null,
      token: null,
      tokenExpiration: null,
    });
  },
};
