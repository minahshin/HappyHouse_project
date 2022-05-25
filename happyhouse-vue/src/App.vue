<template>
  <div id="app">
    <navi-bar id="no" />

    <router-view />

    <main-footer />
  </div>
</template>

<script>
import NaviBar from "@/components/layout/HeaderNaviBar.vue";
import MainFooter from "@/components/layout/MainFooter.vue";

export default {
  name: "App",
  components: {
    NaviBar,
    MainFooter,
  },
};
</script>

<style>
#app {
}

a {
  text-decoration: none;
}

a:hover {
  text-decoration: none;
  font-weight: bold;
  color: rgb(0, 253, 147);
}

a.router-link-exact-active {
  color: #ffffff;
}
</style>
