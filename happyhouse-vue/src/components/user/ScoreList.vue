<template>
  <b-container v-if="scores.length" class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show variant="success"><h3>별점 관리</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table-simple hover responsive id="score-table">
          <b-thead>
            <b-th>아파트</b-th>
            <b-th>내가 준 평점</b-th>
            <b-th> </b-th>
          </b-thead>
          <tbody>
            <score-list-item
              v-for="scoreInfo in pageItems"
              :key="scoreInfo.aptCode"
              v-bind="scoreInfo"
            />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="score-table"
      align="center"
    ></b-pagination>
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>별점을 준 내역이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";
import ScoreListItem from "@/components/user/item/ScoreListItem";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "ScoreList",
  components: {
    ScoreListItem,
  },

  data() {
    return {
      scores: [],
      currentPage: 1,
      perPage: 10,
      pageItems: [],
    };
  },

  computed: {
    ...mapState(memberStore, ["userInfo"]),
    rows() {
      return this.scores.length;
    },
  },
  watch: {
    currentPage() {
      this.setPage();
    },
  },
  created() {
    http
      .get(`/score/list?memberId=${this.userInfo.memberId}`)
      .then(({ data }) => {
        this.scores = data;
        this.setPage();
      });
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    setPage() {
      const { currentPage, perPage } = this;
      const start = (currentPage - 1) * perPage;
      const end = currentPage * perPage;
      this.pageItems = this.scores.slice(start, end);
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
