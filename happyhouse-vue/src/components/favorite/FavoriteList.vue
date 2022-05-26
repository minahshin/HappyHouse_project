<template>
  <b-container v-if="favorites.length" class="bv-example-row mt-3">
    <b-row>
      <b-col cols="6">
        <b-table-simple hover responsive id="fav-table">
          <b-thead head-variant="dark">
            <b-th>즐겨찾은 아파트 목록</b-th>
            <b-th></b-th>
          </b-thead>
          <tbody>
            <favorite-list-item
              v-for="favorite in pageItems"
              :key="favorite.aptName"
              v-bind="favorite"
            />
          </tbody>
        </b-table-simple>
        <b-pagination
          v-model="currentPage"
          :total-rows="rows"
          :per-page="perPage"
          aria-controls="fav-table"
          align="center"
        ></b-pagination>
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
      currentPage: 1,
      perPage: 7,
      pageItems: [],
    };
  },

  computed: {
    ...mapState(memberStore, ["userInfo"]),
    rows() {
      return this.favorites.length;
    },
  },
  created() {
    http.get(`/favorite/list/${this.userInfo.memberId}`).then(({ data }) => {
      this.favorites = data;
      this.setPage();
    });
  },
  watch: {
    currentPage() {
      this.setPage();
    },
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    setPage() {
      const { currentPage, perPage } = this;
      const start = (currentPage - 1) * perPage;
      const end = currentPage * perPage;
      this.pageItems = this.favorites.slice(start, end);
    },
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
