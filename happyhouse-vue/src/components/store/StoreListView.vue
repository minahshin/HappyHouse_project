<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <div style="font-size: 40px">
          총 {{ stores.length }} 개의 검색 결과가 있습니다.
        </div>
        <hr />
        <b-table-simple hover responsive>
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
              v-for="store in stores"
              :key="store.id"
              v-bind="store"
              :isAptDefined="isAptDefined"
            ></store-list-item>
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
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
    };
  },
  components: {
    StoreListItem,
  },
  created() {
    eventBus.$on("getStores", (data) => {
      this.stores = data;
    });
    eventBus.$on("isAptDefined", (data) => {
      this.isAptDefined = data;
    });
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
