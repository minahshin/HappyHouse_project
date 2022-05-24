<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글목록</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button
          variant="outline-primary"
          @click="moveWrite()"
          v-show="isManager"
          >글쓰기</b-button
        >
      </b-col>
    </b-row>
    <b-row>
      <b-col v-if="articles.length">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>글번호</b-th>
              <b-th>카테고리</b-th>
              <b-th>제목</b-th>
              <b-th>작성자</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <notice-list-item
              v-for="article in articles"
              :key="article.nno"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";
import NoticeListItem from "@/components/notice/item/NoticeListItem";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "NoticeList",
  components: {
    NoticeListItem,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      articles: [],
      isManager: false,
    };
  },
  created() {
    http.get(`/notice`).then(({ data }) => {
      this.articles = data;
      if (this.userInfo != null && this.userInfo.isManager == "Y")
        this.isManager = true;
    });
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    moveWrite() {
      this.$router.push({ name: "noticeRegist" });
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
