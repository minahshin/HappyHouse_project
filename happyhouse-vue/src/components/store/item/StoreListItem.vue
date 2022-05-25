<template>
  <b-tr>
    <b-td>{{ storeName }}</b-td>
    <b-td>{{ storeName }}</b-td>
    <b-th class="text-left">{{ jibunAddress }} </b-th>
    <b-td>{{ doroAddress }}</b-td>
    <b-td>{{ zipCode }}</b-td>
  </b-tr>
</template>

<script>
export default {
  name: "StoreListItem",
  props: {
    storeName: String,
    jibunAddress: String,
    doroAddress: String,
    zipCode: String,
  },
};
</script>

<style></style>
