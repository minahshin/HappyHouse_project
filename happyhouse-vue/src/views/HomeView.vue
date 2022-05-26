<template>
  <b-container class="bv-example-row mt-3 text-center">
    <h3 class="underline-steelblue">
      <b-icon icon="house"></b-icon> Happy House
    </h3>
    <br />
    <br />
    <div style="font-size: 20px">당신의 보금자리를 찾아드립니다!</div>
    <br />
    <hr />
    <br />
    <div id="slide">
      <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="4000"
        controls
        indicators
        background="#ababab"
        style="text-shadow: 1px 1px 2px #333"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
      >
        <b-carousel-slide caption="아파트 시세 확인">
          <template #img>
            <router-link to="house">
              <img
                class="d-block img-fluid w-100"
                src="@/assets/집5.jpg"
                alt="image slot"
            /></router-link>
          </template>
        </b-carousel-slide>

        <b-carousel-slide caption="주변 상권 검색">
          <template #img>
            <router-link to="store">
              <img
                class="d-block img-fluid w-100"
                src="@/assets/집1.jpg"
                alt="image slot"
            /></router-link>
          </template>
        </b-carousel-slide>
        <b-carousel-slide caption="공지사항">
          <template #img>
            <router-link to="notice/list">
              <img
                class="d-block img-fluid w-100"
                src="@/assets/7.jpg"
                alt="image slot"
            /></router-link>
          </template>
        </b-carousel-slide>
        <b-carousel-slide caption="Q & A">
          <template #img>
            <router-link to="qna/list">
              <img
                class="d-block img-fluid w-100"
                src="@/assets/2.jpg"
                alt="image slot"
            /></router-link>
          </template>
        </b-carousel-slide>
        <b-carousel-slide caption="회사 소개">
          <template #img>
            <router-link to="aboutUs">
              <img
                class="d-block img-fluid w-100"
                src="@/assets/집.jpg"
                alt="image slot"
            /></router-link>
          </template>
        </b-carousel-slide>
        <b-carousel-slide caption="사이트 맵">
          <template #img>
            <router-link to="siteMap">
              <img
                class="d-block img-fluid w-100"
                src="@/assets/5.jpg"
                alt="image slot"
            /></router-link>
          </template>
        </b-carousel-slide>
      </b-carousel>
    </div>
    <br />

    <b-row>
      <b-col
        ><b-jumbotron
          bg-variant="light"
          text-variant="dark"
          border-variant="info"
        >
          <div style="font-size: 40px">부동산 NEWS</div>
          <br /><real-estate-news-list-view
            :keywords="keywords"
          ></real-estate-news-list-view> </b-jumbotron
      ></b-col>
      <b-col>
        <b-jumbotron
          bg-variant="light"
          text-variant="dark"
          border-variant="warning"
        >
          <div style="font-size: 40px">
            <img src="@/assets/trophy.png" /> 매물 랭킹
            <img src="@/assets/trophy.png" />
          </div>
          <br />
          <best-house-list-view></best-house-list-view
        ></b-jumbotron>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <b-jumbotron
          bg-variant="light"
          text-variant="dark"
          border-variant="secondary"
        >
          <template #header>공지사항</template>
          <notice-list-view :pag="home" />
        </b-jumbotron>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import NoticeListView from "@/components/notice/NoticeListView.vue";
import BestHouseListView from "@/components/house/BestHouseListView.vue";
import RealEstateNewsListView from "@/components/house/RealEstateNewsListView.vue";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "HelloWorld",
  data() {
    return {
      keywords: " ",
      home: 5,
    };
  },
  props: {
    msg: String,
  },
  components: {
    NoticeListView,
    BestHouseListView,
    RealEstateNewsListView,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.underline-steelblue {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(72, 190, 233, 0.3) 30%
  );
  font-size: 40px;
}
</style>
