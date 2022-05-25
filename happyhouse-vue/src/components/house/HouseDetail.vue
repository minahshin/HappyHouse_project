<template>
  <b-container v-if="house" class="bv-example-row">
    <b-row>
      <b-col
        ><h3>{{ house.aptName }}</h3></b-col
      >
    </b-row>
    <b-row class="mb-2 mt-1">
      <b-col> <kakao-map /> </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="secondary">일련번호 : {{ house.no }}</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="primary"
          >아파트 이름 : {{ house.aptName }}
        </b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="info">법정동 : {{ house.dongName }} </b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="warning">층수 : {{ house.floor }}층</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="danger"
          >거래금액 :
          {{
            (parseInt(house.dealAmount.replace(",", "")) * 10000) | price
          }}원</b-alert
        >
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-button block @click="searchMarket" variant="info" class="m-1"
          >주변 상권 검색
        </b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-button block @click="registMarket" variant="warning" class="m-1"
          >즐겨찾기 추가
        </b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import http from "@/api/http";
import KakaoMap from "@/components/KakaoMap.vue";

const houseStore = "houseStore";
const memberStore = "memberStore";

export default {
  name: "HouseDetail",
  components: {
    KakaoMap,
  },
  computed: {
    ...mapState(houseStore, ["house"]),
    ...mapState(memberStore, ["userInfo"]),
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    searchMarket() {
      this.$router.push({
        name: "store",
        params: {
          lat: this.house.lat,
          lng: this.house.lng,
          aptName: this.house.aptName,
        },
      });
    },
    registMarket() {
      http
        .post(`/favorite/regist`, {
          aptCode: this.house.aptCode,
          memberId: this.userInfo.memberId,
        })
        .then(({ data }) => {
          let msg = "이미 등록된 매물입니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.$router.go({ name: "store" });
        });
    },
  },
};
</script>

<style></style>
