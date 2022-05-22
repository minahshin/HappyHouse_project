<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글목록</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <question-search-item></question-search-item>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()"
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
            <question-list-item
              v-for="article in articles"
              :key="article.qno"
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
import QuestionListItem from "@/components/qna/item/QuestionListItem";
import QuestionSearchItem from "@/components/qna/item/QuestionSearchItem.vue";

export default {
  name: "QuestionList",
  components: {
    QuestionListItem,
    QuestionSearchItem,
  },
  data() {
    return {
      articles: [],
    };
  },
  props: {
    type: { type: String },
  },
  created() {
    http
      .get(`/question`, {
        params: {
          writer: this.$route.params.writer,
          categories: this.$route.params.categories,
          keyword: this.$route.params.keyword,
        },
      })
      .then(({ data }) => {
        if (data === "no_result") {
          alert("작성된 글이 없습니다.");
        } else {
          this.articles = data;
        }
      });
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "questionRegist" });
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
