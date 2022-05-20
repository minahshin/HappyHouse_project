import { apiInstance, houseInstance } from "./index.js";

const api = apiInstance();
const house = houseInstance();

function gugunList(success, fail) {
  api.get(`/house/sido`).then(success).catch(fail);
}

function dongList(params, success, fail) {
  api.get(`/house/gugun`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  house.get(`house/search/address`, { params: params }).then(success).catch(fail);
}

export { gugunList, dongList, houseList };
