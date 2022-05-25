<template>
  <b-container v-if="houses && houses.length != 0" class="bv-example-row mt-3">
    <house-list-item
      id="house-list"
      v-for="(house, index) in houses"
      :key="index"
      :house="house"
      :current-page="currentPage"
      :per-page="perPage"
      :items="houses"
    />
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="house-list"
    ></b-pagination>
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>주택 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import HouseListItem from "@/components/house/HouseListItem.vue";
import { mapState } from "vuex";
import { BPagination } from "bootstrap-vue";

const houseStore = "houseStore";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
    BPagination,
  },
  data() {
    return {
      currentPage: 1,
      perPage: 10,
    };
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
    rows() {
      return this.houses.length;
    },
  },
};
</script>

<style></style>
