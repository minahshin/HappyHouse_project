<template>
  <b-container class="bv-example-row mt-3 text-center">
    <div class="underline-hotpink">즐겨찾기</div>
    <br />

    "{{ userInfo.memberName }}" 님의 즐겨찾기 정보입니다.
    <hr />
    <!-- <b-row>
      <b-col cols="8" align="left">
        <b-form-input
          placeholder="Search"
          v-model.trim="search"
          @keypress.enter="search"
        ></b-form-input>
      </b-col>
      <b-col>
        <b-input-group-append>
          <b-button variant="outline-success" @click="registerTodo"
            ><b-icon icon="search"
          /></b-button>
        </b-input-group-append>
      </b-col>
    </b-row>
    <b-row> -->
    <router-view></router-view>
  </b-container>
</template>

<script>
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";
export default {
  name: "FavoriteView",

  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
  },
};
</script>

<style scoped>
.underline-hotpink {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 60%,
    rgba(231, 27, 139, 0.3) 30%
  );
  font-size: 40px;
}
</style>
