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
          <b-nav-item href="#" class="qna"
            ><router-link :to="{ name: 'questionView' }" class="link">
              QNA</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: '' }" class="link">
              About Us</router-link
            ></b-nav-item
          >
          <b-nav-item href="#"
            ><router-link :to="{ name: '' }" class="link"
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
  </div>
</template>

<script>
export default {
  name: "HeaderNaviBar",
};
</script>

<style></style>
