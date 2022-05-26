<template>
  <b-container class="bv-example-row mt-3 text-center">
    <div class="underline-hotpink">About Us</div>
    <br />
    Happy House를 소개합니다!
    <hr />

    <b-row>
      <b-row>
        <div class="box" style="background: #bdbdbd">
          <img class="profile" src="@/assets/민아님.png" />
        </div>
        <div class="box" style="background: #bdbdbd">
          <img class="profile" src="@/assets/양소정.jpg" />
        </div>
      </b-row>

      <b-col align-self="stretch">
        <h5>Happy House는 좋은 집을 소개해드립니다.</h5>
        <hr />
        의식주 중 가장 중요한 "주"에 관한 고민은 모두가 하실 것입니다. <br />
        저희 Happy House는 고객님들의 고민을 줄여드리고자 시세 거래 서비스를
        오픈했습니다.
        <br />많은 이용 부탁드립니다. <br /><br /><br />
        <h5>Happy House 정보</h5>
        <hr />
        공동대표 : 신민아,양소정 <br />
        위치 : 서울특별시 동대문구 싸피동 123-1 <br />
        Tel : 02-1234-5678<br />
        Email : ssafy@happyhouse.com
        <br />
      </b-col>
    </b-row>
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
.box {
  width: 180px;
  height: 180px;
  border-radius: 70%;
  overflow: hidden;
}
.profile {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>
