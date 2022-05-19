<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="dark">
      <b-navbar-brand href="#">
        <router-link to="/">
          <img
            src="@/assets/류피.png"
            class="d-inline-block align-middle"
            width="80px"
            alt="ssafy"
          />
        </router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#"
            ><router-link :to="{ name: 'home' }" class="link"
              ><b-icon icon="house" font-scale="1.5"></b-icon> Home
            </router-link></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: '' }" class="link">
              시세검색</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: '' }" class="link">
              즐겨찾기</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: '' }" class="link">
              지역정보</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: '' }" class="link">
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

        <b-navbar-nav class="ml-auto">
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
          >
            <h1 class="text-black mb-4">Happy House</h1>
            <p class="text-black opacity-8 lead pe-5 me-5">행복한 우리집</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HeaderNaviBar",
};
</script>

<style>
#box2-1 {
  width: 100%;
  height: 300px;
  background-image: url("@/assets/주택.jpg");
  background-size: contain;
}
</style>
