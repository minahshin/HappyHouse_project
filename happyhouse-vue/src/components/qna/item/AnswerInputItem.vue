<template>
  <b-container>
    <b-row class="mb-1">
      <b-col>
        <b-button variant="outline-primary" @click="toggle">답변 등록</b-button>
      </b-col>
    </b-row>
    <br />
    <b-form v-if="show" @submit="onSubmit" @reset="onReset">
      <b-row
        ><b-col
          ><b-form-group id="content-group" label-for="content">
            <b-form-textarea
              id="content"
              v-model="article.content"
              placeholder="답변을 작성해주세요."
              rows="10"
              max-rows="15"
              required
            ></b-form-textarea> </b-form-group></b-col
      ></b-row>
      <b-row>
        <b-col class="text-right">
          <b-button type="submit" variant="primary" class="m-1"
            >글작성</b-button
          >
          <b-button type="reset" variant="danger" class="m-1"
            >초기화</b-button
          ></b-col
        ></b-row
      >
    </b-form>
  </b-container>
</template>

<script>
import http from "@/api/http";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "AnswerInputItem",
  data() {
    return {
      article: {
        content: "",
      },
      show: false,
    };
  },
  props: {
    type: String,
    qno: String,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.article.content &&
        ((msg = "답변 내용을 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.registArticle();
    },
    onReset(event) {
      event.preventDefault();
      this.article.content = "";
    },
    registArticle() {
      if (confirm("답변을 등록하시겠습니까?")) {
        http.post(`/answer/regist`, {
          content: this.article.content,
          qno: this.qno,
          writer: this.userInfo.memberId,
        });
        this.$router.go({ name: "questionView" });
      }
    },
    toggle() {
      this.show = !this.show;
      this.answerType = "register";
    },
  },
};
</script>
