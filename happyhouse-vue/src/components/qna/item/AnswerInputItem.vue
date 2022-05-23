<template>
  <b-container>
    <b-row class="mb-1">
      <b-col>
        <b-button variant="outline-primary" @click="listArticle"
          >답변 등록</b-button
        >
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
// import http from "@/api/http";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "AnswerInputItem",
  data() {
    return {
      article: {},
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
  },
};
</script>
