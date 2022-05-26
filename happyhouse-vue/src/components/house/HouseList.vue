<template>
  <b-container
    v-if="houses && houses.length != 0"
    class="bv-example-row mt-3"
    id="house-list"
  >
    <house-list-item
      v-for="house in pageItems"
      :key="house.no"
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
import { mapState, mapMutations } from "vuex";

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
  computed: {
    ...mapState(houseStore, ["houses"]),
    rows() {
      return this.houses.length;
    },
  },
  created() {
    this.setPage();
    this.CLEAR_HOUSE();
  },
  watch: {
    currentPage() {
      this.setPage();
    },
    houses() {
      this.setPage();
    },
  },
  methods: {
    ...mapMutations(houseStore, ["CLEAR_HOUSE"]),
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
