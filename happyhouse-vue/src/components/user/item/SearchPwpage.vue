<template>
  <b-row>
    <b-col></b-col>
    <b-col cols="8">
      <b-row>
        <b-col>
          <b-alert variant="secondary" show><h3>비밀번호 변경</h3></b-alert>
        </b-col>
      </b-row>
      <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
        <b-form class="text-left" @submit="onSubmit">
          <b-form-group label="변경할 비밀번호:" label-for="memberPw">
            <b-form-input
              type="password"
              id="memberPw"
              v-model="memberDto.memberPw"
              required
              placeholder="변경할 비밀번호 입력...."
            ></b-form-input>
          </b-form-group>

          <b-button type="submit" variant="primary" class="m-1"
            >비밀번호 수정</b-button
          >
        </b-form>
      </b-card>
    </b-col>
    <b-col></b-col>
  </b-row>
</template>

<script>
import http from "@/api/http";

export default {
  name: "SearchPwpage",
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
  props: {
    memberId: {
      type: String,
    },
  },

  created() {
    http.get(`/user/${this.$route.params.memberId}`).then(({ data }) => {
      this.memberDto = data;
      this.memberDto.memberPw = "";
    });
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";

      err &&
        !this.memberDto.memberPw &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.memberName.focus());

      if (!err) alert(msg);
      else this.modifyArticle();
    },

    modifyArticle() {
      http
        .put(`/user/update`, {
          memberId: this.memberDto.memberId,
          memberPw: this.memberDto.memberPw,
          memberName: this.memberDto.memberName,
          memberEmail: this.memberDto.memberEmail,
          memberTel: this.memberDto.memberTel,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다. 다시 로그인해주세요.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.

          this.$router.push({ name: "signIn" });
        });
    },
  },
};
</script>

<style></style>
