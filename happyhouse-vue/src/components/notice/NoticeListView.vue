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
        <b-table-simple hover responsive id="notice-table">
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
              v-for="article in pageItems"
              :key="article.nno"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>

    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="notice-table"
      align="center"
    ></b-pagination>
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
    rows() {
      return this.articles.length;
    },
  },
  data() {
    return {
      articles: [],
      isManager: false,
      currentPage: 1,
      perPage: 10,
      pageItems: [],
    };
  },
  props: {
    pag: Number,
  },
  created() {
    if (this.pag === 5) this.perPage = 5;
    http.get(`/notice`).then(({ data }) => {
      this.articles = data;
      this.setPage();
      if (this.userInfo != null && this.userInfo.isManager == "Y")
        this.isManager = true;
    });
  },
  watch: {
    currentPage() {
      this.setPage();
    },
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    moveWrite() {
      this.$router.push({ name: "noticeRegist" });
    },
    setPage() {
      const { currentPage, perPage } = this;
      const start = (currentPage - 1) * perPage;
      const end = currentPage * perPage;
      this.pageItems = this.articles.slice(start, end);
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
