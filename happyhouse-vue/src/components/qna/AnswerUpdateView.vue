<template>
  <b-container class="bv-example-row mt-3">
    <answer-input-item type="update" />
  </b-container>
</template>

<script>
import AnswerInputItem from "@/components/qna/item/AnswerInputItem";

export default {
  name: "AnswerUpdate",
  components: {
    AnswerInputItem,
  },
};
</script>