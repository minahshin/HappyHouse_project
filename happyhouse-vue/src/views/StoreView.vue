<template>
  <b-container class="bv-example-row mt-3 text-center">
    <div class="underline-hotpink">상권정보</div>
    <hr />
    <store-search-bar
      :lat="`${this.$route.params.lat}`"
      :lng="`${this.$route.params.lng}`"
      :aptName="`${this.$route.params.aptName}`"
    ></store-search-bar>
    <store-list></store-list>
  </b-container>
</template>

<script>
import StoreSearchBar from "@/components/store/StoreSearchBar.vue";
import StoreList from "@/components/store/StoreListView.vue";

export default {
  name: "StoreView",
  components: {
    StoreSearchBar,
    StoreList,
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
