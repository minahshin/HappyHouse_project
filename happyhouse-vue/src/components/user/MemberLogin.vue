<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>로그인</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="isLoginError"
              >아이디 또는 비밀번호를 확인하세요.</b-alert
            >
            <b-form-group label="아이디:" label-for="userid">
              <b-form-input
                id="userid"
                v-model="memberDto.memberId"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="memberDto.memberPw"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-row>
              <b-col cols="6" align="left">
                <b-button
                  type="button"
                  variant="primary"
                  class="m-1"
                  @click="confirm"
                  >로그인</b-button
                >
                <b-button
                  type="button"
                  variant="success"
                  class="m-1"
                  @click="movePage"
                  >회원가입</b-button
                >
              </b-col>
              <b-col cols="6">
                비밀번호를 잊으셨나요?
                <b-button
                  align="right"
                  type="button"
                  variant="warning"
                  class="m-1"
                  @click="searchPw"
                  >Pw찾기</b-button
                >
              </b-col>
            </b-row>
            <div>
              <h1>Kakao Login Test</h1>
              <span th:if="${userId==null}">
                <a
                  href="https://kauth.kakao.com/oauth/authorize?client_id=a6d46d13539efc9ae43e7772448b569c&redirect_uri=http://localhost/login&response_type=code"
                >
                  <img src="@/assets/카카오.png" />
                </a>
              </span>
              <span th:if="${userId!=null}">
                <form name="logout" action="http://localhost/logout">
                  <input type="submit" value="로그아웃" />
                </form>
              </span>
            </div>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberLogin",
  data() {
    return {
      memberDto: {
        memberId: null,
        memberPw: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.memberDto);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
    movePage() {
      this.$router.push({ name: "signUp" });
    },
    searchPw() {
      this.$router.push({ name: "searchpwd" });
    },
  },
};
</script>

<style></style>
