import { guList, dongList, houseList, scoreStatus } from "@/api/house.js";

const houseStore = {
  namespaced: true,
  state: {
    gus: [{ value: null, text: "검색할 구를 선택하세요" }],
    dongs: [{ value: null, text: "검색할 구를 먼저 선택하세요" }],
    houses: [],
    house: null,
    scoreInfo: { score: 0.0, userScore: 0 },
  },

  getters: {},

  mutations: {
    SET_GU_LIST: (state, gus) => {
      gus.forEach((gu) => {
        state.gus.push({ value: gu.guCode, text: gu.gugunName });
      });
    },
    SET_DONG_LIST: (state, dongs) => {
      dongs.forEach((dong) => {
        state.dongs.push({ value: dong.dongCode, text: dong.dongName });
      });
    },
    CLEAR_GU_LIST: (state) => {
      state.gus = [{ value: null, text: "검색할 구를 선택하세요" }];
    },
    CLEAR_DONG_LIST: (state) => {
      state.dongs = [{ value: null, text: "검색할 동을 선택하세요" }];
    },
    SET_HOUSE_LIST: (state, houses) => {
      state.houses = houses;
    },
    SET_DETAIL_HOUSE: (state, params) => {
      state.house = params.house;
      state.scoreInfo.score = params.score;
      state.scoreInfo.userScore = params.userScore;
    },
  },

  actions: {
    getGu: ({ commit }) => {
      guList(
        ({ data }) => {
          commit("SET_GU_LIST", data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    getDong: ({ commit }, guCode) => {
      const params = {
        gu: guCode,
      };
      dongList(
        params,
        ({ data }) => {
          commit("SET_DONG_LIST", data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    getHouseList: ({ commit }, { guCode, dongCode, keyword }) => {
      const params = {
        guCode: guCode,
        dongCode: dongCode,
        keyword: keyword,
      };
      houseList(
        params,
        (response) => {
          commit("SET_HOUSE_LIST", response.data);
        },
        (error) => {
          console.log(error);
        },
      );
    },
    detailHouse: ({ commit }, { house, userInfo }) => {
      let id = "";
      if (userInfo) {
        id = userInfo.memberId;
      }
      console.log(id);
      scoreStatus(
        { aptCode: house.aptCode, memberId: id },
        (response) => {
          commit("SET_DETAIL_HOUSE", {
            house: house,
            score: response.data.aptScore,
            userScore: response.data.userScore,
          });
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};

export default houseStore;
