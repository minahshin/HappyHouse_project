<template>
  <b-row>
    <b-col>
      <b-row class="mb-1">
        <b-col>
          <b-card
            :header-html="`<div><h3>RE: ${subject} 의 답변입니다.</h3></div><div class='text-right'><h6>등록 시간 : ${regDate}</h6></div>`"
            class="mb-2"
            border-variant="dark"
            no-body
          >
            <b-card-body class="text-left">
              <div v-if="!showUpdateWindow" v-html="message"></div>
              <b-form-group
                v-if="showUpdateWindow"
                id="content-group"
                label-for="content"
              >
                <b-form-textarea
                  id="content"
                  v-model="newContent"
                  placeholder="답변을 작성해주세요."
                  rows="10"
                  max-rows="15"
                  required
                ></b-form-textarea>
              </b-form-group>
            </b-card-body>
            <b-row>
              <b-col class="text-right">
                <b-button
                  variant="outline-info"
                  size="sm"
                  @click="modifyArticle"
                  class="mr-2 padding-button"
                  v-show="this.isManager"
                  >글 수정</b-button
                >
                <b-button
                  variant="outline-danger"
                  size="sm"
                  class="padding-button"
                  @click="deleteArticle"
                  v-show="this.isManager"
                  v-if="!showUpdateWindow"
                  >글 삭제</b-button
                >
                <b-button
                  variant="outline-danger"
                  size="sm"
                  class="padding-button"
                  @click="cancelModify"
                  v-show="this.isManager"
                  v-else
                  >취소</b-button
                >
              </b-col>
            </b-row>
          </b-card>
        </b-col>
      </b-row>
    </b-col>
  </b-row>
</template>

<script>
import http from "@/api/http";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  data() {
    return {
      showUpdateWindow: false,
      newContent: "",
    };
  },
  props: {
    subject: String,
    isManager: Boolean,
    qno: String,
    ano: Number,
    content: String,
    regDate: String,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
    message() {
      if (this.content) return this.content.split("\n").join("<br>");
      return "";
    },
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    modifyArticle() {
      if (!this.showUpdateWindow) {
        this.showUpdateWindow = true;
        this.newContent = this.content;
      } else {
        if (confirm("답변을 수정하시겠습니까?")) {
          if (this.isManager) {
            http.put(`/answer/update`, {
              ano: this.ano,
              content: this.newContent,
            });
            this.$router.go({ name: "questionView" });
          } else {
            alert("접근 권한이 없습니다.");
          }
        }
      }
    },
    deleteArticle() {
      if (confirm("삭제하시겠습니까?")) {
        if (this.isManager) {
          http.delete(`/answer/delete/${this.ano}`);
          this.$router.go({ name: "questionView" });
        } else {
          alert("접근 권한이 없습니다.");
        }
      }
    },
    showUpdate() {
      this.showUpdateWindow = true;
    },
    cancelModify() {
      this.showUpdateWindow = false;
    },
  },
};
</script>

<style>
.padding-button {
  padding: 10;
}
</style>
