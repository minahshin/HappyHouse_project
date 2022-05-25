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
      favoriteDto: {
        memberId: this.usesrInfo.memberId,
        aptCode: this.aptCode,
      },
    };
  },
  created() {
    // let apt;
    // apt = this.aptCode;
  },

  props: {
    aptName: String,
    aptCode: String,
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    deleteFavorite() {
      if (confirm("삭제하시겠습니까?")) {
        this.favoriteDto.aptCode = this.aptCode;
        this.favoriteDto.memberId = this.usesrInfo.memberId;

        http.delete(`/favorite/delete/${this.favoriteDto}`);
        alert("삭제되었습니다.");
        this.$router.push({ name: "favoriteList" });
      }
    },
  },
};
</script>

<style></style>
