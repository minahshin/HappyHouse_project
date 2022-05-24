<template>
  <div>
    <b-row>
      <b-col>
        <b-alert show variant="dark"><h3>아파트 시세 검색</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mt-4 mb-4 text-center">
      <b-col class="sm-3">
        <b-form-select
          id="guInfo"
          v-model="guCode"
          :options="gus"
          @change="dongList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select
          id="dongInfo"
          v-model="dongCode"
          :options="dongs"
        ></b-form-select>
      </b-col>
      <b-col>
        <b-form-input
          id="aptName"
          v-model="aptName"
          type="text"
          placeholder="아파트 이름에 포함된 단어 입력"
        ></b-form-input>
      </b-col>
    </b-row>
    <b-row>
      <b-col
        ><b-button block @click="searchApt" variant="primary" class="m-1"
          >아파트 시세 검색</b-button
        >
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseSearchBar",
  data() {
    return {
      guCode: null,
      dongCode: null,
      aptName: "",
    };
  },
  computed: {
    ...mapState(houseStore, ["gus", "dongs", "houses"]),
  },
  created() {
    this.CLEAR_GU_LIST();
    this.getGu();
  },
  methods: {
    ...mapActions(houseStore, ["getGu", "getDong", "getHouseList"]),
    ...mapMutations(houseStore, ["CLEAR_GU_LIST", "CLEAR_DONG_LIST"]),
    dongList() {
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.guCode) this.getDong(this.guCode);
    },
    searchApt() {
      if (this.guCode || this.aptName) {
        this.getHouseList({
          guCode: this.guCode,
          dongCode: this.dongCode,
          keyword: this.aptName,
        });
      } else alert("매물을 찾기 위한 정보를 입력해주세요.");
    },
  },
};
</script>

<style></style>
