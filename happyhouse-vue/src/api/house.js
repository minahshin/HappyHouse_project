import { apiInstance } from "./index.js";

const api = apiInstance();

function guList(success, fail) {
  api.get(`/house/map/gu`).then(success).catch(fail);
}

function dongList(params, success, fail) {
  api.get(`/house/map/dong`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  api.get(`/house/search`, { params: params }).then(success).catch(fail);
}

function scoreStatus(params, success, fail) {
  api.get(`/score`, { params: params }).then(success).catch(fail);
}

export { guList, dongList, houseList, scoreStatus };
