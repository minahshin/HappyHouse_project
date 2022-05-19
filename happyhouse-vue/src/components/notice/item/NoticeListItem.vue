<template>
  <b-tr>
    <b-td>{{ nno }}</b-td>
    <b-td>{{ category }}</b-td>
    <b-th class="text-left">
      <router-link :to="{ name: 'noticeView', params: { nno: nno } }">{{
        subject
      }}</router-link>
    </b-th>
    <b-td>{{ writer }}</b-td>
    <b-td>{{ regDate | dateFormat }}</b-td>
  </b-tr>
</template>

<script>
import moment from "moment";

export default {
  name: "NoticeListItem",
  props: {
    nno: Number,
    writer: String,
    category: String,
    subject: String,
    regDate: String,
  },
  filters: {
    dateFormat(regDate) {
      return moment(new Date(regDate)).format("YY.MM.DD");
    },
  },
};
</script>

<style></style>
