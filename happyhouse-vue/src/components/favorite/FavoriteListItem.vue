<template>
  <b-tr>
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
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "FavoriteListItem",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      memberId: this.usesrInfo.memberId,
      useraptCode: this.aptCode,
    };
  },

  props: {
    aptName: String,
    aptCode: String,
  },
  created() {
    // let reaptCode = "";
    // reaptCode = this.useraptCode;
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
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
