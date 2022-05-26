<template>
  <b-row
    class="m-2"
    @click="selectHouse"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="2" class="text-center align-self-center">
      <b-img
        thumbnail
        src="https://picsum.photos/250/250/?image=58"
        alt="Image 1"
      ></b-img>
    </b-col>
    <b-col cols="10" class="align-self-center">
      [{{ house.no }}] {{ house.aptName }}
    </b-col>
  </b-row>
</template>

<script>
import { eventBus } from "@/main";
import { mapActions, mapState, mapMutations } from "vuex";

const memberStore = "memberStore";
const houseStore = "houseStore";

export default {
  name: "HouseListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    house: Object,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    ...mapActions(houseStore, ["detailHouse"]),
    ...mapMutations(memberStore, ["SET_USER_INFO"]),
    selectHouse() {
      eventBus.getNewsKeyword(this.house.dongName);
      this.detailHouse({ house: this.house, userInfo: this.userInfo });
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.apt {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}
</style>
