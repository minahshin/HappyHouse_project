<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <div style="font-size: 40px">
          총 {{ stores.length }} 개의 검색 결과가 있습니다.
        </div>
        <hr />
        <b-table-simple hover responsive id="store-table">
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>상점</b-th>
              <b-th>분류</b-th>
              <b-th>주소</b-th>
              <b-th>우편번호</b-th>
              <b-th v-if="isAptDefined">거리</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <store-list-item
              v-for="store in pageItems"
              :key="store.id"
              v-bind="store"
              :isAptDefined="isAptDefined"
            ></store-list-item>
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="store-table"
      align="center"
    ></b-pagination>
  </b-container>
</template>

<script>
import StoreListItem from "@/components/store/item/StoreListItem.vue";
import { eventBus } from "@/main";

export default {
  name: "StoreList",
  data() {
    return {
      stores: [],
      isAptDefined: false,
      currentPage: 1,
      perPage: 20,
      pageItems: [],
    };
  },
  components: {
    StoreListItem,
  },
  created() {
    eventBus.$on("getStores", (data) => {
      this.stores = data;
      this.setPage();
    });
    eventBus.$on("isAptDefined", (data) => {
      this.isAptDefined = data;
    });
  },
  computed: {
    rows() {
      return this.stores.length;
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
      this.pageItems = this.stores.slice(start, end);
    },
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
