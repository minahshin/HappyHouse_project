<template>
  <b-tr>
    <b-th class="text-left">
      <b-link @click="moveToHouseList">{{ aptName }}</b-link>
    </b-th>
    <b-th>
      <b-form-rating
        v-model="newScore"
        variant="warning"
        readonly
        show-value
        show-value-max
        no-border
      ></b-form-rating>
    </b-th>
  </b-tr>
</template>

<script>
import { mapActions } from "vuex";

const houseStore = "houseStore";

export default {
  name: "BestHouseListItem",
  data() {
    return {
      newScore: 0,
    };
  },
  props: {
    aptName: String,
    aptCode: Number,
    average: Number,
  },
  created() {
    this.newScore = this.average;
  },
  methods: {
    ...mapActions(houseStore, ["getHouseList"]),
    moveToHouseList() {
      this.getHouseList({
        guCode: "",
        dongCode: "",
        keyword: this.aptName,
      });
      this.$router.push({ name: "house" });
    },
  },
};
</script>

<style></style>
