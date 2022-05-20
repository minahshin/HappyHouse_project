<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>회원정보 수정</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-form-group label="아이디:" label-for="userid">
              <b-form-input
                id="userid"
                required
                placeholder="아이디 입력...."
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                required
                placeholder="비밀번호 입력...."
              ></b-form-input>
            </b-form-group>

            <b-form-group label="이름" label-for="username">
              <b-form-input
                id="username"
                required
                placeholder="이름 입력...."
              ></b-form-input>
            </b-form-group>
            <b-form-group label="전화번호:" label-for="usertel">
              <b-form-input
                id="userid"
                required
                placeholder="전화번호 입력...."
              ></b-form-input>
            </b-form-group>

            <b-form-group label="e-mail" label-for="useremail">
              <b-form-input
                id="useremail"
                required
                placeholder="e-mail 입력...."
              ></b-form-input>
            </b-form-group>
            <b-button type="button" variant="primary" class="m-1"
              >회원탈퇴</b-button
            >
            <b-button type="button" variant="success" class="m-1"
              >정보수정</b-button
            >
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: "MemberUpdate",
};
</script>

<style></style>
