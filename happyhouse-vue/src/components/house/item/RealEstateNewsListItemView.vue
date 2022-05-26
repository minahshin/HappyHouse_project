<template>
  <b-tr>
    <b-th class="text-left">
      <b-link @click="moveToNews">{{ title }}</b-link>
    </b-th>
  </b-tr>
</template>

<script>
export default {
  name: "RealEstateNewsListItem",
  data() {
    return {
      newTitle: "",
    };
  },
  props: {
    title: String,
    originallink: String,
    link: String,
  },
  methods: {
    moveToNews() {
      window.open(this.link, "_blank");
    },
  },
};
</script>

<style></style>
