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
        <b-alert show variant="success"
          ><b-form-rating
            v-model="scoreInfo.score"
            variant="warning"
            readonly
            show-value
            show-value-max
          ></b-form-rating>
          <br />
          <div>
            <b-input-group>
              <b-form-rating
                v-model="scoreInfo.userScore"
                variant="warning"
                no-border
              ></b-form-rating>
              <b-input-group-append>
                <b-button @click="updateScore">평가하기!</b-button>
              </b-input-group-append>
            </b-input-group>
          </div>
        </b-alert>
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
        <b-button
          block
          v-if="isFavCheck"
          @click="deleteFavorite"
          variant="danger"
          class="m-1"
          >즐겨찾기 삭제
        </b-button>
        <b-button
          block
          v-else
          @click="registFavorite"
          variant="warning"
          class="m-1"
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
    ...mapState(houseStore, ["house", "scoreInfo", "isFavCheck"]),
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
    registFavorite() {
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
        });
      this.isFavCheck = true;
    },
    deleteFavorite() {
      http
        .delete(
          `/favorite/delete?memberId=${this.userInfo.memberId}&aptCode=${this.house.aptCode}`,
        )
        .then(({ data }) => {
          let msg = "즐겨찾기에 등록되어있지 않은 매물입니다.";
          if (data === "success") {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
        });
      this.isFavCheck = false;
    },
    updateScore() {
      if (this.userInfo) {
        http.post(`/score/add`, {
          memberId: this.userInfo.memberId,
          aptCode: this.house.aptCode,
          aptName: this.house.aptName,
          score: this.scoreInfo.userScore,
        });
        alert("별점이 등록되었습니다.");
        http.get(`/score?aptCode=${this.house.aptCode}`).then(({ data }) => {
          this.scoreInfo.score = data.aptScore;
        });
      } else {
        alert("로그인 후 이용 가능합니다.");
      }
    },
  },
};
</script>

<style></style>
