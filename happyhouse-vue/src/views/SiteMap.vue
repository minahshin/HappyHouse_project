<template>
  <b-container class="bv-example-row mt-3 text-center">
    <div class="underline-hotpink">Site Map</div>
    <br />
    Happy House
    <hr />

    <h5>Happy House</h5>
    <hr />
    <div>
      <router-link :to="{ name: 'home' }" class="link"> Home</router-link>
    </div>
    <div>
      <router-link :to="{ name: 'house' }" class="link"> 시세검색</router-link>
    </div>

    <div>
      <router-link :to="{ name: 'store' }" class="link"> 상권검색</router-link>
    </div>
    <div>
      <router-link :to="{ name: 'noticeList' }" class="link">
        공지사항</router-link
      >
    </div>
    <div>
      <router-link :to="{ name: 'questionList' }" class="link">
        QNA</router-link
      >
    </div>

    <div>
      <router-link :to="{ name: 'about' }" class="link"> About Us</router-link>
    </div>

    <br />
    <hr />
    <h5>User</h5>
    <hr />
    <div v-if="userInfo">
      <div>
        <router-link :to="{ name: 'favorite' }" class="link">
          즐겨찾기</router-link
        >
      </div>
      <div>
        <router-link :to="{ name: 'userScore' }" class="link">
          별점 관리</router-link
        >
      </div>
      <div>
        <router-link :to="{ name: 'mypage' }" class="link">
          내정보보기</router-link
        >
      </div>
    </div>

    <div v-else>
      <div>
        <router-link :to="{ name: 'signIn' }" class="link"> Login</router-link>
      </div>
      <div>
        <router-link :to="{ name: 'signUp' }" class="link">
          Sign Up</router-link
        >
      </div>
    </div>
    <br />
  </b-container>
</template>

<script>
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "AboutView",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
  },
};
</script>

<style scoped>
.underline-hotpink {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 60%,
    rgba(231, 27, 139, 0.3) 30%
  );
  font-size: 40px;
}
</style>
