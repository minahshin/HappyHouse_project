import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/aboutUs",
    name: "about",
    component: AboutView,
  },
  {
    path: "siteMap",
    name: "siteMap",
    component: () => import("@/views/SiteMap.vue"),
  },
  {
    path: "/house",
    name: "house",
    component: () => import("@/views/HouseView.vue"),
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/MemberView.vue"),
    children: [
      {
        path: "login",
        name: "login",
        component: () => import("@/components/user/MemberLogin.vue"),
      },
      {
        path: "singup",
        name: "signUp",
        component: () => import("@/components/user/MemberRegister.vue"),
      },
      {
        path: "userinfo",
        name: "userinfo",
        component: () => import("@/components/user/MemberMyPage.vue"),
      },
    ],
  },
  {
    path: "/qna",
    name: "qna",
    component: () => import("@/views/QuestionView.vue"),
    redirect: "/qna/list",
    children: [
      {
        path: "list",
        name: "questionList",
        component: () => import("@/components/qna/QuestionListView.vue"),
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
      {
        path: ":qno",
        name: "questionView",
        component: () => import("@/components/qna/QuestionDetailView.vue"),
      },
    ],
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import("@/views/NoticeView.vue"),
    redirect: "/notice/list",
    children: [
      {
        path: "list",
        name: "noticeList",
        component: () => import("@/components/notice/NoticeListView.vue"),
      },
      {
        path: ":nno",
        name: "noticeView",
        component: () => import("@/components/notice/NoticeDetailView.vue"),
      },
      {
        path: "update",
        name: "noticeUpdate",
        component: () => import("@/components/notice/NoticeUpdateView.vue"),
      },
      {
        path: "regist",
        name: "noticeRegist",
        component: () => import("@/components/notice/NoticeRegistView.vue"),
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
