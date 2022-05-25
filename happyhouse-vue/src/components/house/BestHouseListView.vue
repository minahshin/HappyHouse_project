<template>
  <b-container>
    <b-table-simple hover responsive>
      <b-thead head-variant="info">
        <b-th>아파트</b-th>
        <b-th>별점</b-th>
      </b-thead>
      <tbody>
        <best-house-list-item
          v-for="house in houses"
          :key="house.aptName"
          v-bind="house"
        />
      </tbody> </b-table-simple
  ></b-container>
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
    };
  },
  created() {
    http.get(`/score/best`).then(({ data }) => {
      this.houses = data;
    });
  },
};
</script>
