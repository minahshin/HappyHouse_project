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
      <b-col lg="6">
        <b-nav align="center" class="nav-footer justify-content-lg-end">
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
      </b-col>
    </b-row>
    <br />
  </footer>
</template>

<script>
export default {
  name: "MainFooter",
};
</script>

<style></style>
