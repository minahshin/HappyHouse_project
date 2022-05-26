<template>
  <div>
    <b-row>
      <b-col>
        <b-alert show variant="secondary"
          ><h3>
            <span v-show="aptNameDefined">{{ aptName }}</span> 주변 상권 시세
            검색
          </h3></b-alert
        >
      </b-col>
    </b-row>
    <b-row class="mt-4 mb-4 text-center" v-if="!aptNameDefined">
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
    </b-row>
    <b-row class="mt-4 mb-4 text-center" v-else>
      <b-col sm="2">아파트 이름 : </b-col>
      <b-col sm="5">
        <b-form-input :disabled="true" v-model="aptNameStr"> </b-form-input>
      </b-col>
      <b-col sm="2"> 반경(0 ~ 2000m) : </b-col>
      <b-col sm="3">
        <b-form-input
          type="number"
          id="distance"
          v-model="distance"
          min="0"
          max="2000"
        ></b-form-input>
      </b-col>
    </b-row>
    <b-row class="mt-4 mb-4 text-center">
      <b-col>
        <b-form-group id="category-group" label-for="category">
          <b-form-checkbox-group>
            카테고리 선택 :
            <b-form-checkbox
              id="cate_restaurant"
              v-model="category"
              value="음식"
              >음식</b-form-checkbox
            >
            <b-form-checkbox id="cate_shop" v-model="category" value="소매"
              >소매점/마트</b-form-checkbox
            >
            <b-form-checkbox
              id="cate_service"
              v-model="category"
              value="생활서비스"
              >생활 서비스(이,미용 등)</b-form-checkbox
            >
            <b-form-checkbox
              id="cate_hobby"
              v-model="category"
              value="관광/여가/오락"
              >취미 생활/관광</b-form-checkbox
            ><b-form-checkbox id="cate_edu" v-model="category" value="학문/교육"
              >교육</b-form-checkbox
            >
            <b-form-checkbox id="cate_sport" v-model="category" value="스포츠"
              >스포츠</b-form-checkbox
            >
            <b-form-checkbox
              id="cate_accomodation"
              v-model="category"
              value="숙박"
              >숙박시설</b-form-checkbox
            >
            <b-form-checkbox
              id="cate_realestate"
              v-model="category"
              value="부동산"
              >부동산 중개업</b-form-checkbox
            ></b-form-checkbox-group
          >
        </b-form-group>
      </b-col>
    </b-row>
    <b-row class="mt-4 mb-4 text-center">
      <b-col sm="2">검색어 : </b-col>
      <b-col sm="7">
        <b-form-input v-model="keyword"> </b-form-input>
      </b-col>
      <b-col sm="2">어린이 안심 상점 : </b-col>
      <b-col>
        <b-form-checkbox
          id="kidsSafe"
          v-model="isKidsSafe"
          value="true"
        ></b-form-checkbox>
      </b-col>
    </b-row>
    <b-row>
      <b-col
        ><b-button block @click="searchStore" variant="primary" class="m-1"
          >상권 검색</b-button
        >
      </b-col>
    </b-row>
  </div>
</template>

<script>
import http from "@/api/http";
import { mapState, mapActions, mapMutations } from "vuex";
import { eventBus } from "@/main";

const houseStore = "houseStore";

export default {
  name: "StoreSearchBar",
  data() {
    return {
      aptNameDefined: false,
      aptNameStr: this.aptName,
      guCode: null,
      dongCode: null,
      distance: 0,
      category: [],
      keyword: null,
      isKidsSafe: false,
    };
  },
  props: {
    lat: String,
    lng: String,
    aptName: String,
  },
  computed: {
    ...mapState(houseStore, ["gus", "dongs", "houses"]),
  },
  created() {
    if (this.aptName !== "undefined") this.aptNameDefined = true;
    else {
      this.CLEAR_GU_LIST();
      this.getGu();
    }
  },
  methods: {
    ...mapActions(houseStore, ["getGu", "getDong", "getHouseList"]),
    ...mapMutations(houseStore, ["CLEAR_GU_LIST", "CLEAR_DONG_LIST"]),
    dongList() {
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.guCode) this.getDong(this.guCode);
    },
    searchStore() {
      eventBus.isAptDefined(this.aptNameDefined);
      if (this.aptNameDefined) {
        http
          .get(`/shop/around`, {
            params: {
              lat: this.lat,
              lng: this.lng,
              categoryStr: this.category.join(","),
              distance: this.distance,
              keyword: this.keyword,
              isKidsSafe: this.isKidsSafe,
            },
          })
          .then(({ data }) => {
            eventBus.getStores(data);
          });
      } else {
        if (!this.dongCode) {
          alert("상권을 검색하실 동을 선택해주세요.");
        } else {
          http
            .get(`/shop/address`, {
              params: {
                dongCode: this.dongCode,
                categoryStr: this.category.join(","),
                keyword: this.keyword,
                isKidsSafe: this.isKidsSafe,
              },
            })
            .then(({ data }) => {
              eventBus.getStores(data);
            });
        }
      }
    },
  },
};
</script>

<style></style>
