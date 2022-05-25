<template>
  <footer class="footer px-4">
    <hr />
    <b-row align-v="center" class="justify-content-lg-between">
      <b-col lg="6">
        <div
          class="copyright text-center text-lg-left text-muted font-weight-bold"
        >
          © 2022 Happy House, Inc
        </div>
      </b-col>

      <router-link to="/">
        <img
          src="@/assets/오리.png"
          class="d-inline-block align-middle"
          width="50px"
          alt="home"
        />
      </router-link>
      <b-nav align="center" class="nav-footer justify-content-lg-end">
        <b-nav-item href="" target="_blank">
          <router-link :to="{ name: 'house' }" class="link"
            >시세검색</router-link
          >
        </b-nav-item>
        <b-nav-item href="" target="_blank">
          <router-link :to="{ name: 'store' }" class="link"
            >상권검색</router-link
          >
        </b-nav-item>

        <b-nav-item href="" target="_blank">
          <router-link :to="{ name: 'noticeList' }" class="link"
            >공지사항</router-link
          >
        </b-nav-item>
        <b-nav-item href="" target="_blank">
          <router-link :to="{ name: 'questionList' }" class="link"
            >QNA</router-link
          >
        </b-nav-item>
        <b-nav-item href="" target="_blank">
          <router-link :to="{ name: 'about' }" class="link"
            >About Us</router-link
          >
        </b-nav-item>
        <b-nav-item href="" target="_blank">
          <router-link :to="{ name: 'siteMap' }" class="link"
            >Site Map</router-link
          >
        </b-nav-item>
      </b-nav>
    </b-row>
    <br />
  </footer>
</template>

<script>
export default {
  name: "MainFooter",
};
</script>
