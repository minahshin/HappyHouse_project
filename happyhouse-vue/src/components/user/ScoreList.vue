<template>
  <b-container v-if="scores.length" class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show variant="success"><h3>별점 관리</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table-simple hover responsive>
          <b-thead>
            <b-th>아파트</b-th>
            <b-th>내가 준 평점</b-th>
            <b-th> </b-th>
          </b-thead>
          <tbody>
            <score-list-item
              v-for="scoreInfo in scores"
              :key="scoreInfo.aptCode"
              v-bind="scoreInfo"
            />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
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
    };
  },

  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  created() {
    http
      .get(`/score/list?memberId=${this.userInfo.memberId}`)
      .then(({ data }) => {
        this.scores = data;
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
