<template>
  <b-container class="bv-example-row mt-3">
    <answer-input-item type="register" />
  </b-container>
</template>

<script>
import AnswerInputItem from "@/components/qna/item/AnswerInputItem";

export default {
  name: "AnswerRegist",
  components: {
    AnswerInputItem,
  },
};
</script>