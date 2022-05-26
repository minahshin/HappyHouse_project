<template>
  <b-container
    v-if="houses && houses.length != 0"
    class="bv-example-row mt-3"
    id="house-list"
  >
    <house-list-item
      v-for="(house, index) in pageItems"
      :key="index"
      :house="house"
    />
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="house-list"
      align="center"
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

const houseStore = "houseStore";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
  },
  data() {
    return {
      currentPage: 1,
      perPage: 17,
      pageItems: [],
    };
  },
  created() {
    this.setPage();
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
    rows() {
      return this.houses.length;
    },
  },
  watch: {
    currentPage() {
      this.setPage();
    },
  },
  methods: {
    setPage() {
      const { currentPage, perPage } = this;
      const start = (currentPage - 1) * perPage;
      const end = currentPage * perPage;
      this.pageItems = this.houses.slice(start, end);
    },
  },
};
</script>

<style></style>
