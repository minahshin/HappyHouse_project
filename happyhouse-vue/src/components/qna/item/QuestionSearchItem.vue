<template>
  <div id="searchApp">
    <b-row v-on:click="toggle"
      ><b-col
        ><b-alert show variant="success"
          ><h3>{{ searchOpener }}</h3></b-alert
        ></b-col
      ></b-row
    >
    <b-row class="mb-1" v-if="show">
      <b-col style="text-align: left">
        <b-form @submit="onSearch" @reset="onReset">
          <b-form-group id="writer-group" label="작성자:" label-for="writer">
            <b-form-input
              id="writer"
              v-model="search.writer"
              type="text"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="category-group"
            label="카테고리 선택:"
            label-for="category"
          >
            <b-form-checkbox-group>
              <b-form-checkbox
                id="category_user"
                v-model="search.category"
                value="회원"
                >회원 관련 문의</b-form-checkbox
              >
              <b-form-checkbox
                id="category_site"
                v-model="search.category"
                value="사이트 이용"
                >사이트 이용 관련 문의</b-form-checkbox
              >
              <b-form-checkbox
                id="category_report"
                v-model="search.category"
                value="신고"
                >부적절한 사용자 및 컨텐츠 신고</b-form-checkbox
              >
              <b-form-checkbox
                id="category_etc"
                v-model="search.category"
                value="기타"
                >기타 문의</b-form-checkbox
              ></b-form-checkbox-group
            >
          </b-form-group>

          <b-form-group id="keyword-group" label="검색어:" label-for="keyword">
            <b-form-input
              id="keyword"
              v-model="search.keyword"
              type="text"
              placeholder="검색어 입력"
            ></b-form-input>
          </b-form-group>

          <b-col class="text-right">
            <b-button type="submit" variant="primary" class="m-1"
              >검색</b-button
            >
            <b-button type="reset" variant="danger" class="m-1"
              >초기화</b-button
            >
          </b-col>
        </b-form>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: "questionSearchItem",
  data() {
    return {
      search: {
        category: [],
        writer: "",
        keyword: "",
        userid: "", // to be replaced
      },
      show: false,
      searchOpener: "▼ 검색 하기 ▼",
    };
  },
  props: {
    type: { type: String },
  },
  methods: {
    onReset(event) {
      event.preventDefault();
      this.search.writer = "";
      this.search.category = "";
      this.search.keyword = "";
    },
    onSearch(event) {
      event.preventDefault();

      if (this.$route.path === "/qna/search") {
        this.$router.replace({
          name: "questionReSearch",
          params: {
            writer: this.search.writer,
            categories: this.search.category.join(","),
            keyword: this.search.keyword,
            userid: "", // to be replaced
          },
        });
      } else {
        this.$router.replace({
          name: "questionSearch",
          params: {
            writer: this.search.writer,
            categories: this.search.category.join(","),
            keyword: this.search.keyword,
            userid: "", // to be replaced
          },
        });
      }
    },
    toggle: function () {
      if (this.show) {
        this.searchOpener = "▼ 검색 하기 ▼";
      } else {
        this.searchOpener = "▲ 검색창 닫기 ▲";
      }
      this.show = !this.show;
    },
  },
};
</script>

<style>
.v-enter-active,
.v-leave-active {
  transition: all 1s;
}
.v-enter,
.v-leave-to {
  opacity: 0;
  transform: translateX(-20px);
}
</style>
