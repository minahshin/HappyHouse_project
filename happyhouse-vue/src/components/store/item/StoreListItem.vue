<template>
  <b-tr>
    <b-th
      ><b-link @click="moveLink">{{ name }}</b-link></b-th
    >
    <b-th>
      {{ storeType }}
    </b-th>
    <b-th
      >{{ jibunAddress }} <br />
      {{ doroAddress }}</b-th
    >
    <b-th>{{ zipCode }}</b-th>
    <b-th v-if="isAptDefined">{{ distance | viewMeter }} m</b-th>
  </b-tr>
</template>

<script>
export default {
  name: "StoreListItem",
  props: {
    name: String,
    bigType: String,
    mediumType: String,
    storeType: String,
    jibunAddress: String,
    doroAddress: String,
    zipCode: String,
    distance: Number,
    isAptDefined: Boolean,
  },
  filters: {
    viewMeter(distance) {
      return distance * 1000;
    },
  },
  methods: {
    moveLink() {
      let jibunArray = this.jibunAddress.split(" ");
      let nameLink =
        "https://map.naver.com/v5/search/" +
        this.name +
        " " +
        jibunArray[1] +
        " " +
        jibunArray[2];
      window.open(nameLink, "_blank");
    },
  },
};
</script>

<style></style>
