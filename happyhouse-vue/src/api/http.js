import axios from "axios";

// axios 객체 생성
export default axios.create({
  baseURL: "http://ec2-52-79-222-87.ap-northeast-2.compute.amazonaws.com:9999",
  headers: {
    "Content-type": "application/json",
  },
});
