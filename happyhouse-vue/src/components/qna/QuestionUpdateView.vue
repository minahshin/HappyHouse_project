<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글수정</h3></b-alert>
      </b-col>
    </b-row>
    <question-input-item type="modify" />
  </b-container>
</template>

<script>
import QuestionInputItem from "@/components/qna/item/QuestionInputItem.vue";

export default {
  name: "QuestionUpdate",
  components: {
    QuestionInputItem,
  },
};
</script>

<style></style>
