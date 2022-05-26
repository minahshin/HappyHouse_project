<template>
  <b-container>
    <b-table-simple hover responsive id="besthouse-table">
      <b-thead head-variant="info">
        <b-th>아파트</b-th>
        <b-th>별점</b-th>
      </b-thead>
      <tbody>
        <best-house-list-item
          v-for="house in pageItems"
          :key="house.aptName"
          v-bind="house"
        />
      </tbody>
    </b-table-simple>
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="besthouse-table"
      align="center"
    ></b-pagination>
  </b-container>
</template>

<script>
import http from "@/api/http";
import BestHouseListItem from "@/components/house/item/BestHouseListItem.vue";

export default {
  components: {
    BestHouseListItem,
  },
  data() {
    return {
      houses: [],
      currentPage: 1,
      perPage: 5,
      pageItems: [],
    };
  },
  created() {
    http.get(`/score/best`).then(({ data }) => {
      this.houses = data;
      this.setPage();
    });
  },
  watch: {
    currentPage() {
      this.setPage();
    },
  },
  computed: {
    rows() {
      return this.houses.length;
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
