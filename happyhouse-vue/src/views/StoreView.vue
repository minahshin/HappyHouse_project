<template>
  <b-container class="bv-example-row mt-3 text-center">
    <div class="underline-hotpink">상권정보</div>
    <br />
    상권정보 페이지입니다.
    <hr />
    <router-view></router-view>
  </b-container>
</template>

<script>
export default {
  name: "NoticeView",
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
