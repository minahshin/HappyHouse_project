<template>
  <b-tr v-if="this.isSecret === 'N' || this.writer == userInfo.memberId">
    <b-td>{{ qno }}</b-td>
    <b-td>{{ category }}</b-td>
    <b-th class="text-left">
      <router-link :to="{ name: 'questionView', params: { qno: qno } }">{{
        subject
      }}</router-link>
    </b-th>
    <b-td>{{ writer }}</b-td>
    <b-td>{{ regDate | dateFormat }}</b-td>
  </b-tr>
</template>

<script>
import moment from "moment";

import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "QuestionListItem",
  props: {
    qno: Number,
    writer: String,
    category: String,
    subject: String,
    regDate: String,
    isSecret: String,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
  },

  filters: {
    dateFormat(regDate) {
      return moment(new Date(regDate)).format("YY.MM.DD");
    },
  },
};
</script>

<style></style>
