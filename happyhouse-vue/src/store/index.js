import Vue from "vue";
import Vuex from "vuex";
// import http from "@/api/http";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

import memberStore from "@/store/modules/memberStore.js";
import houseStore from "@/store/modules/houseStore";

const store = new Vuex.Store({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    memberStore,
    houseStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});

export default store;
