<template>
  <div>
    <b-navbar id="nav" toggleable="lg" type="dark" fixed="top">
      <b-navbar-brand href="#">
        <router-link to="/">
          <b-icon icon="house" font-scale="3"></b-icon>
        </router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#"
            ><router-link :to="{ name: 'home' }" class="link">
              Home
            </router-link></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: 'house' }" class="link">
              시세검색</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: 'store' }" class="link">
              상권검색</router-link
            ></b-nav-item
          >
          <b-nav-item href="#" class="notice"
            ><router-link :to="{ name: 'noticeList' }" class="link">
              공지사항</router-link
            ></b-nav-item
          >
          <b-nav-item href="#" class="qna"
            ><router-link :to="{ name: 'questionList' }" class="link">
              QNA</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: 'about' }" class="link">
              About Us</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: 'siteMap' }" class="link"
              >Site Map</router-link
            ></b-nav-item
          >
        </b-navbar-nav>

        <b-navbar-nav class="ml-auto" v-if="userInfo">
          <b-nav-item class="align-self-center"
            ><b-avatar
              variant="primary"
              v-text="userInfo ? userInfo.memberId.charAt(0).toUpperCase() : ''"
            ></b-avatar>
            {{ userInfo.memberId }}님 환영합니다.</b-nav-item
          >
          <b-nav-item class="align-self-center"
            ><router-link
              :to="{ name: 'favorite' }"
              class="link align-self-center"
              >즐겨찾기</router-link
            ></b-nav-item
          >
          <b-nav-item class="align-self-center"
            ><router-link
              :to="{ name: 'userScore' }"
              class="link align-self-center"
              >별점관리</router-link
            ></b-nav-item
          >
          <b-nav-item class="align-self-center" v-if="userInfo.isManager == 'Y'"
            ><router-link
              :to="{ name: 'manager' }"
              class="link align-self-center"
              >회원관리</router-link
            ></b-nav-item
          >
          <b-nav-item class="align-self-center"
            ><router-link
              :to="{ name: 'mypage' }"
              class="link align-self-center"
              >내정보보기</router-link
            ></b-nav-item
          >
          <b-nav-item
            class="link align-self-center"
            @click.prevent="onClickLogout"
            >로그아웃</b-nav-item
          >
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto" v-else>
          <b-nav-item-dropdown right>
            <template #button-content>
              <b-icon icon="people" font-scale="2"></b-icon>
            </template>
            <b-dropdown-item href="#"
              ><router-link :to="{ name: 'signUp' }" class="link"
                ><b-icon icon="person-circle"></b-icon> 회원가입</router-link
              ></b-dropdown-item
            >
            <b-dropdown-item href="#"
              ><router-link :to="{ name: 'signIn' }" class="link"
                ><b-icon icon="key"></b-icon> 로그인</router-link
              ></b-dropdown-item
            >
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <div id="box2-1" class="page-header">
      <span class="mask bg-gradient-dark opacity-5"></span>
      <div class="container">
        <div class="row">
          <div
            class="col-lg-6 col-md-7 d-flex justify-content-center flex-column"
          ></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "HeaderNaviBar",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      // console.log("memberStore : ", ms);
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      this.$router.push({ name: "home" });
    },
  },
};
</script>

<style>
#box2-1 {
  padding: 50px;
}

#nav {
  background-color: rgba(204, 204, 255, 0.9);
}
</style>
