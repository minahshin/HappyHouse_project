<template>
  <b-container v-if="favorites.length" class="bv-example-row mt-3">
    <b-row @click="selectHouse">
      <b-col cols="6">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-th>즐겨찾은 아파트 목록</b-th>
          </b-thead>
          <tbody>
            <favorite-list-item
              v-for="favorite in favorites"
              :key="favorite.aptName"
              v-bind="favorite"
            />
          </tbody>
        </b-table-simple>
      </b-col>
      <b-col cols="6"> <kakao-map /></b-col>
    </b-row>
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>즐겨찾기 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";
import FavoriteListItem from "@/components/favorite/FavoriteListItem";
import KakaoMap from "@/components/KakaoMap";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "FavoriteList",
  components: {
    FavoriteListItem,
    KakaoMap,
  },

  data() {
    return {
      favorites: [],
    };
  },

  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  created() {
    // let memberId = "";
    // if (this.userInfo != null) {
    //   memberId = this.userInfo.memberId;
    // }
    http.get(`/favorite/list/${this.userInfo.memberId}`).then(({ data }) => {
      this.favorites = data;
    });
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
