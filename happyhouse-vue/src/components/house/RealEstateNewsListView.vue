<template>
  <b-container>
    <b-table-simple hover responsive id="news-table">
      <b-thead head-variant="info">
        <b-th>제목</b-th>
      </b-thead>
      <tbody>
        <real-estate-news-list-item-view
          v-for="news in pageItems"
          :key="news.title"
          v-bind="news"
        />
      </tbody>
    </b-table-simple>
    <b-row
      ><b-col>
        <b-pagination
          v-model="currentPage"
          :total-rows="rows"
          :per-page="perPage"
          aria-controls="news-table"
          align="center"
        ></b-pagination></b-col></b-row
  ></b-container>
</template>

<script>
import http from "@/api/http";
import RealEstateNewsListItemView from "./item/RealEstateNewsListItemView.vue";
import { eventBus } from "@/main";

export default {
  components: { RealEstateNewsListItemView },
  data() {
    return {
      newses: [],
      currentPage: 1,
      perPage: 5,
      pageItems: [],
      newKeyword: "",
    };
  },
  props: {
    keywords: String,
  },
  created() {
    this.newKeyword = this.keywords;
    console.log("keyword : " + this.keywords);
    if (!this.keywords) {
      eventBus.$on("getNewsKeyword", (data) => {
        this.newKeyword = data;
      });
    }
    http.get(`/news?keywords=${this.newKeyword}`).then(({ data }) => {
      this.newses = data;
      this.setPage();
    });
  },
  computed: {
    rows() {
      return this.newses.length;
    },
  },
  watch: {
    currentPage() {
      this.setPage();
    },
    news() {
      this.setPage();
    },
    newKeyword() {
      console.log(this.newKeyword);
      http.get(`/news?keywords=${this.newKeyword}`).then(({ data }) => {
        this.newses = data;
        this.setPage();
      });
    },
  },
  methods: {
    setPage() {
      const { currentPage, perPage } = this;
      const start = (currentPage - 1) * perPage;
      const end = currentPage * perPage;
      this.pageItems = this.newses.slice(start, end);
    },
  },
};
</script>
