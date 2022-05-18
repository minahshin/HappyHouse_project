<template>
  <b-container class="bv-example-row mt-3 text-center">
    <div class="underline-hotpink">Q & A</div>
    <br />
    HappyHouse 이용에 관한 질문을 자유롭게 남기실 수 있습니다.
    <hr />
    <router-view></router-view>
  </b-container>
</template>

<script>
export default {
  name: "QuestionView",
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
