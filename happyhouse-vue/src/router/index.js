import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/question",
    name: "question",
    component: () => import("@/views/QuestionListView.vue"),
    children: [
      {
        path: ":qno",
        name: "questionView",
        component: () => import("@/components/qna/QuestionView.vue"),
      },
      {
        path: "update",
        name: "questionUpdate",
        component: () => import("@/components/qna/QuestionUpdateView.vue"),
      },
      {
        path: "regist",
        name: "questionRegist",
        component: () => import("@/components/qna/QuestionRegistView.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
