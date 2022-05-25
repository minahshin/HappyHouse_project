<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script>
import { mapState } from "vuex";
const houseStore = "houseStore";

export default {
  name: "KakaoMap",
  computed: {
    ...mapState(houseStore, ["house"]),
  },

  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=915cffed372954b7b44804ed422b9cf0";
      document.head.appendChild(script);
    }
    //마커
    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
      mapCenter = new kakao.maps.LatLng(this.house.lat, this.house.lng), // 지도의 중심 좌표
      mapOption = {
        center: mapCenter, // 지도의 중심 좌표
        level: 4, // 지도의 확대 레벨
      };

    // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    // 지도에 올릴 마커를 생성합니다.
    var mMarker = new kakao.maps.Marker({
      position: mapCenter, // 지도의 중심좌표에 올립니다.
      map: map, // 생성하면서 지도에 올립니다.
    });

    // 지도에 올릴 장소명 인포윈도우 입니다.
    var mLabel = new kakao.maps.InfoWindow({
      position: mapCenter, // 지도의 중심좌표에 올립니다.
      content: this.house.aptName, // 인포윈도우 내부에 들어갈 컨텐츠 입니다.
    });
    mLabel.open(map, mMarker); // 지도에 올리면서, 두번째 인자로 들어간 마커 위에 올라가도록 설정합니다.

    var rvContainer = document.getElementById("roadview"); // 로드뷰를 표시할 div
    var rv = new kakao.maps.Roadview(rvContainer); // 로드뷰 객체 생성
    var rc = new kakao.maps.RoadviewClient(); // 좌표를 통한 로드뷰의 panoid를 추출하기 위한 로드뷰 help객체 생성
    var rvResetValue = {}; //로드뷰의 초기화 값을 저장할 변수
    rc.getNearestPanoId(mapCenter, 50, function (panoId) {
      rv.setPanoId(panoId, mapCenter); //좌표에 근접한 panoId를 통해 로드뷰를 실행합니다.
      rvResetValue.panoId = panoId;
    });
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(this.house.lat, this.house.lng),
        level: 5,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 500px;
  height: 500px;

  margin: 20px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
