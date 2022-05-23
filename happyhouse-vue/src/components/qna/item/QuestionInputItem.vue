<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="writer-group"
          label="작성자:"
          label-for="writer"
          description="작성자를 입력하세요."
        >
          <b-form-input
            id="writer"
            :disabled="true"
            v-model="article.writer"
            type="text"
            required
            placeholder="작성자 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="category-group"
          label="카테고리:"
          label-for="category"
        >
          <b-select v-model="article.category">
            <option disabled value="">카테고리를 선택하세요</option>
            <option
              v-for="cate in cateList"
              :value="cate.value"
              :key="cate.text"
              required
            >
              {{ cate.text }}
            </option>
          </b-select>
        </b-form-group>

        <b-form-group
          id="subject-group"
          label="제목:"
          label-for="subject"
          description="제목을 입력하세요."
        >
          <b-form-input
            id="subject"
            v-model="article.subject"
            type="text"
            required
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="article.content"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
          ></b-form-textarea>
        </b-form-group>

        <b-form-group id="secret-group" label="" label-for="secret">
          <b-form-checkbox
            id="secret"
            v-model="article.isSecret"
            value="Y"
            unchecked-value="N"
            >비밀글 설정</b-form-checkbox
          ></b-form-group
        >

        <b-col class="text-right">
          <b-button
            type="submit"
            variant="primary"
            class="m-1"
            v-if="this.type === 'register'"
            >글작성</b-button
          >
          <b-button type="submit" variant="primary" class="m-1" v-else
            >글수정</b-button
          >
          <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
        </b-col>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import http from "@/api/http";

const memberStore = "memberStore";

export default {
  name: "QuestionInputItem",
  data() {
    return {
      article: {
        qno: 0,
        category: "",
        writer: "",
        subject: "",
        content: "",
        isSecret: "N",
      },
      cateList: [
        {
          text: "회원 관련 문의",
          value: "회원",
        },
        {
          text: "사이트 이용 관련 문의",
          value: "사이트 이용",
        },
        {
          text: "부적절한 사용자 및 컨텐츠 신고",
          value: "신고",
        },
        {
          text: "기타 문의",
          value: "기타",
        },
      ],
    };
  },
  props: {
    type: { type: String },
  },
  created() {
    if (this.type === "modify") {
      http.get(`/question/${this.$route.params.qno}`).then(({ data }) => {
        this.article = data.question;
      });
    }
    this.article.writer = this.userInfo.memberId;
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
      !this.article.writer &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.writer.focus());
      err &&
        !this.article.category &&
        ((msg = "카테고리를 선택해주세요"), (err = false));
      err &&
        !this.article.subject &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.article.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else
        this.type === "register" ? this.registArticle() : this.modifyArticle();
    },
    onReset(event) {
      event.preventDefault();
      this.article.qno = 0;
      this.article.category = "";
      this.article.subject = "";
      this.article.content = "";
      this.article.isSecret = "N";
    },
    registArticle() {
      http
        .post(`/question/regist`, {
          category: this.article.category,
          writer: this.article.writer,
          subject: this.article.subject,
          content: this.article.content,
          isSecret: this.article.isSecret,
        })
        .then(({ data }) => {
          let msg = "등록 처리 중 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    modifyArticle() {
      http
        .put(`/question/update`, {
          qno: this.article.qno,
          writer: this.article.writer,
          subject: this.article.subject,
          content: this.article.content,
          category: this.article.category,
          isSecret: this.article.isSecret,
        })
        .then(({ data }) => {
          let msg = "수정 처리 중 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.push({ name: "questionList" });
        });
    },
    moveList() {
      this.$router.push({ name: "questionList" });
    },
  },
};
</script>

<style></style>
