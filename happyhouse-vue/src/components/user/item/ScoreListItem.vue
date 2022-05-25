<template>
  <b-tr>
    <b-th class="text-left">
      <b-link @click="moveToHouseList">{{ aptName }}</b-link>
    </b-th>
    <b-th
      ><b-input-group>
        <b-form-rating
          v-model="newScore"
          variant="warning"
          no-border
        ></b-form-rating>
        <b-input-group-append>
          <b-button @click="updateScore">평가하기!</b-button>
        </b-input-group-append>
      </b-input-group></b-th
    >
    <b-th>
      <b-button variant="outline-danger" size="sm" @click="deleteScore"
        >삭제</b-button
      >
    </b-th>
  </b-tr>
</template>

<script>
import http from "@/api/http";
import { mapState, mapMutations, mapActions } from "vuex";

const memberStore = "memberStore";
const houseStore = "houseStore";

export default {
  name: "ScoreListItem",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      newScore: 0,
    };
  },

  props: {
    aptName: String,
    aptCode: Number,
    score: Number,
  },
  created() {
    this.newScore = this.score;
  },
  methods: {
    ...mapActions(houseStore, ["getHouseList"]),
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    deleteScore() {
      if (confirm("삭제하시겠습니까?")) {
        console.log(this.userInfo.memberId + " " + this.aptCode);
        http.delete(`/score/delete`, {
          params: {
            memberId: this.userInfo.memberId,
            aptCode: this.aptCode,
          },
        });
        alert("삭제되었습니다.");
        this.$router.go({ name: "userScore" });
      }
    },
    updateScore() {
      http.post(`/score/add`, {
        memberId: this.userInfo.memberId,
        aptCode: this.aptCode,
        aptName: this.aptName,
        score: this.newScore,
      });
      alert("별점이 등록되었습니다.");
      this.$router.go({ name: "userScore" });
    },
    moveToHouseList() {
      this.getHouseList({
        guCode: "",
        dongCode: "",
        keyword: this.aptName,
      });
      this.$router.push({ name: "house" });
    },
  },
};
</script>

<style></style>
