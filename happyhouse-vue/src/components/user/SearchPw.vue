<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>비밀번호 찾기</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-form-group label="아이디:" label-for="userid">
              <b-form-input
                id="userid"
                v-model="memberDto.memberId"
                required
                placeholder="아이디 입력...."
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이메일:" label-for="useremail">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="memberDto.memberEmail"
                required
                placeholder="이메일 입력...."
              ></b-form-input>
            </b-form-group>

            <b-col cols="6">
              <b-button
                align="right"
                type="button"
                variant="warning"
                class="m-1"
                @click="searchPw"
                >Pw찾기</b-button
              >
            </b-col>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "SearchPw",
  data() {
    return {
      memberDto: {
        memberId: "",
        memberPw: "",
        memberName: "",
        memberEmail: "",
        memberTel: "",
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    searchPw() {
      http
        .post(`/user/searchpwd`, {
          memberId: this.memberDto.memberId,
          memberEmail: this.memberDto.memberEmail,
        })
        .then(({ data }) => {
          let msg = "일치하는 정보가 없습니다.";
          if (data === "fail") {
            alert(msg);
          } else {
            msg = "새로운 비밀번호를 설정하세요.";
            alert(msg);
            this.memberDto = data;
            //this.$router.push({ name: "searchpwdpage" });
            this.moveModifyArticle();
          }
        });
    },
    moveModifyArticle() {
      this.$router.push({
        name: "Searchpwdpage",
        params: { memberId: this.memberDto.memberId },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },

    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.memberDto);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "update" });
      }
    },
  },
};
</script>

<style></style>
