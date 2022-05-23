import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";

import store from "@/store/index.js";

Vue.use(VueRouter);

// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  // console.log(store);
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const getUserInfo = store._actions["memberStore/getUserInfo"];
  let token = sessionStorage.getItem("access-token");
  if (checkUserInfo == null && token) {
    await getUserInfo(token);
  }
  if (checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    next({ name: "signIn" });
    // router.push({ name: "signIn" });
  } else {
    // console.log("로그인 했다.");
    next();
  }
};

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
    path: "/siteMap",
    name: "siteMap",
    component: () => import("@/views/SiteMap.vue"),
  },
  {
    path: "/favorite",
    name: "favorite",
    component: () => import("@/views/FavoriteView.vue"),
  },
  {
    path: "/store",
    name: "store",
    component: () => import("@/views/StoreView.vue"),
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
        path: "/searchpwd",
        name: "searchpwd",
        component: () => import("@/components/user/SearchPw.vue"),
      },
      {
        path: "mypage",
        name: "mypage",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/user/MemberMyPage.vue"),
      },
      {
        path: "signin",
        name: "signIn",
        component: () => import("@/components/user/MemberLogin.vue"),
      },
      {
        path: "signup",
        name: "signUp",
        component: () => import("@/components/user/MemberRegister.vue"),
      },
      {
        path: "userinfo",
        name: "userinfo",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/user/MemberMyPage.vue"),
      },
      {
        path: "update",
        name: "memberUpdate",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/user/MemberUpdate.vue"),
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
        path: "search",
        name: "questionSearch",
        component: () => import("@/components/qna/QuestionSearchView.vue"),
      },
      {
        path: "search_re",
        name: "questionReSearch",
        component: () => import("@/components/qna/QuestionReSearchView.vue"),
      },
      {
        path: "update",
        name: "questionUpdate",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/qna/QuestionUpdateView.vue"),
      },
      {
        path: "regist",
        name: "questionRegist",
        beforeEnter: onlyAuthUser,
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
