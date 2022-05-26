<template>
  <b-tr>
    <b-th class="text-left">
      <b-link @click="moveToHouseList">{{ aptName }}</b-link>
    </b-th>
    <b-th>
      <b-button variant="outline-danger" size="sm" @click="deleteFavorite"
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
  name: "FavoriteListItem",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
    ...mapState(houseStore, ["gus", "dongs", "houses"]),
  },
  data() {
    return {
      memberId: "",
      useraptCode: "",
      house: [],
    };
  },
  props: {
    aptName: String,
    aptCode: Number,
  },
  created() {
    this.memberId = this.userInfo.memberId;
    this.useraptCode = this.aptCode;
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    ...mapActions(houseStore, ["getHouseList"]),
    deleteFavorite() {
      if (confirm("삭제하시겠습니까?")) {
        http.delete(`/favorite/delete`, {
          params: {
            memberId: this.userInfo.memberId,
            aptCode: this.aptCode,
          },
        });
        alert("삭제되었습니다.");
        this.$router.go({ name: "favorite" });
      }
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
