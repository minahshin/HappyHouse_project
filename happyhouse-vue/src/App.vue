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
#no {
  padding: 48px;
}
#nav {
  background-color: #ffffff;
  background-color: rgba(175, 175, 175, 0.331);
}
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
  color: #0c0a0a;
}
</style>
