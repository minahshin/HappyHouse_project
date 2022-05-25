<template>
  <b-container v-if="userInfo.isManager == 'Y'">
    <b-container v-if="members.length" class="bv-example-row mt-3">
      <b-row>
        <b-col>
          <b-alert show><h3>회원관리</h3></b-alert>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-table-simple hover responsive>
            <b-thead head-variant="dark">
              <b-tr>
                <b-th>아이디</b-th>
                <b-th>이름</b-th>
                <b-th>이메일</b-th>
                <b-th>전화번호</b-th>
                <b-th> </b-th>
              </b-tr>
            </b-thead>
            <tbody>
              <member-list-item
                v-for="member in members"
                :key="member.nno"
                v-bind="member"
              />
            </tbody>
          </b-table-simple>
        </b-col>
      </b-row>
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert show>회원 목록이 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
  </b-container>

  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>관리자만 접근 가능합니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";
import MemberListItem from "@/components/user/item/MemberListItem.vue";
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "ManagerListView",
  components: {
    MemberListItem,
  },
  data() {
    return {
      members: [],
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  created() {
    http.get(`/user`).then(({ data }) => {
      this.members = data;
    });
  },
  methods: {
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
  },
};
</script>

<style></style>
