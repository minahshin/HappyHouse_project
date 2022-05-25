<template>
  <b-tr @click="selectHouse">
    <b-th class="text-left">
      <router-link
        :to="{ name: 'favoriteInfo', params: { aptName: aptName } }"
        >{{ aptName }}</router-link
      >
    </b-th>
    <b-button variant="outline-danger" size="sm" @click="deleteFavorite"
      >삭제</b-button
    >
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
      memberId: this.usesrInfo.memberId,
      useraptCode: this.aptCode,
      house: [],
    };
  },

  props: {
    aptName: String,
    aptCode: String,
  },
  created() {},
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    ...mapActions(houseStore, ["detailHouse"]),
    selectHouse() {
      this.detailHouse(this.house);
    },
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
  },
};
</script>

<style></style>
