import Vue from "vue";
import Vuex from "vuex";
// import http from "@/api/http";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

import memberStore from "@/store/modules/memberStore.js";

const store = new Vuex.Store({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    memberStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});

export default store;
