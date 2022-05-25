<template>
  <b-tr>
    <b-td>{{ memberId }}</b-td>
    <b-td>{{ memberName }}</b-td>
    <b-td>{{ memberEmail }}</b-td>
    <b-td>{{ memberTel }}</b-td>

    <b-button variant="outline-danger" size="sm" @click="deleteArticle"
      >탈퇴</b-button
    >
  </b-tr>
</template>

<script>
import http from "@/api/http";

export default {
  name: "MemberListItem",
  props: {
    memberId: String,
    memberName: String,
    memberEmail: String,
    memberTel: String,
    isManager: String,
  },

  methods: {
    deleteArticle() {
      if (confirm(this.memberId + " 회원을 삭제하시겠습니까?")) {
        http.delete(`/user/delete/${this.memberId}`);
        alert("삭제되었습니다.");
        this.$router.go({ name: "manager" });
      }
    },
  },
};
</script>

<style></style>
