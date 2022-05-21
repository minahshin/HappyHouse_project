<template>
  <b-row>
    <b-col></b-col>
    <b-col cols="8">
      <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
        <b-form class="text-left" @submit="onSubmit" @reset="onReset">
          <b-form-group label="아이디:" label-for="memberId">
            <b-form-input
              id="memberId"
              :disabled="isWriter"
              v-model="memberDto.memberId"
              type="text"
              required
              placeholder="아이디 입력...."
            ></b-form-input>
          </b-form-group>

          <b-form-group label="비밀번호:" label-for="memberPw">
            <b-form-input
              type="password"
              id="memberPw"
              v-model="memberDto.memberPw"
              required
              placeholder="비밀번호 입력...."
            ></b-form-input>
          </b-form-group>

          <b-form-group label="이름" label-for="memberName">
            <b-form-input
              id="memberName"
              v-model="memberDto.memberName"
              required
              placeholder="이름 입력...."
            ></b-form-input>
          </b-form-group>
          <b-form-group label="전화번호:" label-for="memberTel">
            <b-form-input
              id="memberTel"
              v-model="memberDto.memberTel"
              required
              placeholder="전화번호 입력...."
            ></b-form-input>
          </b-form-group>

          <b-form-group label="e-mail" label-for="memberEmail">
            <b-form-input
              id="memberEmail"
              v-model="memberDto.memberEmail"
              required
              placeholder="e-mail 입력...."
            ></b-form-input>
          </b-form-group>
          <b-button
            type="submit"
            variant="primary"
            class="m-1"
            v-if="this.type === 'register'"
            >가입완료</b-button
          >
          <b-button type="submit" variant="primary" class="m-1" v-else
            >회원정보수정</b-button
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
  name: "MemberInputItem",
  data() {
    return {
      memberDto: {
        memberId: "",
        memberPw: "",
        memberName: "",
        memberEmail: "",
        memberTel: "",
      },
      isWriter: false,
    };
  },
  props: {
    type: { type: String },
  },
  created() {
    if (this.type === "modify") {
      http
        .get(`/notice/userinfo/${this.$route.params.memberId}`)
        .then(({ data }) => {
          this.memberDto = data;
        });
      this.isWriter = true;
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.memberDto.memberId &&
        ((msg = "아이디를 입력해주세요"),
        (err = false),
        this.$refs.writer.focus());
      err &&
        !this.memberDto.memberPw &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.memberName.focus());
      err &&
        !this.memberDto.memberEmail &&
        ((msg = "이메일을 입력해주세요"),
        (err = false),
        this.$refs.memberName.focus());
      err &&
        !this.memberDto.memberTel &&
        ((msg = "전화번호를 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else
        this.type === "register" ? this.registArticle() : this.modifyArticle();
    },
    onReset(event) {
      event.preventDefault();
      this.memberDto.memberId = "";
      this.memberDto.memberPw = "";
      this.memberDto.memberName = "";
      this.memberDto.memberEmail = "";
      this.memberDto.memberTel = "";
      this.$router.push({ name: "home" });
    },
    registArticle() {
      http
        .post(`/user/signup`, {
          memberId: this.memberDto.memberId,
          memberPw: this.memberDto.memberPw,
          memberName: this.memberDto.memberName,
          memberEmail: this.memberDto.memberEmail,
          memberTel: this.memberDto.memberTel,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    modifyArticle() {
      http
        .get(`/user/userinfo`, {
          nno: this.article.nno,
          writer: this.article.writer,
          subject: this.article.subject,
          content: this.article.content,
          category: this.article.category,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.push({ name: "home" });
        });
    },
    moveList() {
      this.$router.push({ name: "signIn" });
    },
  },
};
</script>

<style></style>
