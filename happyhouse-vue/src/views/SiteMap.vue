<template>
  <b-container class="bv-example-row mt-3 text-center">
    <div class="underline-hotpink">Site Map</div>
    <br />
    Happy House
    <hr />

    <h5>Happy House</h5>
    <hr />
    <div>
      <b-link href="#" disabled>Home</b-link>
    </div>
    <div>
      <b-link href="#" disabled>시세검색</b-link>
    </div>
    <div>
      <b-link href="#" disabled>즐겨찾기</b-link>
    </div>
    <div>
      <b-link href="#" disabled>지역정보</b-link>
    </div>
    <div>
      <b-link href="#" disabled>상권검색</b-link>
    </div>
    <div>
      <b-link href="#" disabled>공지사항</b-link>
    </div>
    <div>
      <b-link href="#" disabled>QNA</b-link>
    </div>
    <div>
      <b-link href="#" disabled>About Us</b-link>
    </div>
    <br />
    <hr />
    <h5>User</h5>
    <hr />
    <div>
      <b-link href="#" disabled>Login</b-link>
    </div>
    <div>
      <b-link href="#" disabled>Sign Up</b-link>
    </div>
    <br />
  </b-container>
</template>

<script>
export default {
  name: "AboutView",
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
