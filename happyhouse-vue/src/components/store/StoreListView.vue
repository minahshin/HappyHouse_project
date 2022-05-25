<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      {{ stores }}
      <b-col>
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>글번호</b-th>
              <b-th>카테고리</b-th>
              <b-th>제목</b-th>
              <b-th>작성자</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>
          <tbody></tbody>
        </b-table-simple>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
// import StoreListItem from "@/components/store/item/StoreListItem";

export default {
  name: "StoreList",
  data() {
    return {
      stores: [],
    };
  },
  // components: {
  //   StoreListItem,
  // },
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
