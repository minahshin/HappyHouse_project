$(document).ready(function () {
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		if(container){
			var options = { //지도를 생성할 때 필요한 기본 옵션
					center: new kakao.maps.LatLng(37.566826, 126.9786567), //지도의 중심좌표.
					level: 10 //지도의 레벨(확대, 축소 정도)
			};
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴			
			var geocoder = new kakao.maps.services.Geocoder();
		}
		
          // server에서 넘어온 data
          $.ajax({
            url: '../js/csvData.jsp',
            type: 'GET',
            success: function (response) {
              makeList(response);
            },
            error: function (xhr, status, msg) {
              console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
            },
          });
        var gu_list = []; // 읽어온 데이터에서 구 정보를 중복없이 저장
        var dong_list = []; // 읽어온 데이터에서 동 정보를 중복없이 저장
        var input_data;
        function makeList(data) {
          var datalist = data.split('\n'); // '\r\n'으로 구분시 오류 발생
          input_data = data.split('\n');
          $('#datalist').empty();
          $.each(datalist, function(index, item){
        	  var data = item.split(',');
        	  var tr=$('<tr>');
        	  $.each(data, function(i, info){
        		  if(index > 0 && i == 0){
        			  var address = info.split(' ')
        			  var gu_dong = address[1]+", "+address[2];
        			  // address[0] : 시
        			  // address[1] : 구
        			  // address[2] : 동
        			  if(gu_list.indexOf(address[1])==-1){
        				  gu_list.push(address[1]);
        			  }
        			  if(dong_list.indexOf(gu_dong)==-1){
        				  dong_list.push(gu_dong);
        				  // 카카오 지도 api에 마커 띄워주는 부분
        				  geocoder.addressSearch(gu_dong, function(result, status){
        					  	// 파싱해온 데이터에서 좌표정보를 제공하지 않기 때문에
        					  	// 도로명주소를 검색해서 좌표를 가져온 뒤 해당 좌표의 마커를 지도에 표시한다
	  							if (status === kakao.maps.services.Status.OK) {
	  						        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	  						        // 결과값으로 받은 위치를 마커로 표시합니다
	  						        var marker = new kakao.maps.Marker({
	  						            map: map,
	  						            position: coords
	  						        });
	  						    } 
	  						})
        			  }
        		  }
        		  $(`<td>${info}</td>`).appendTo(tr);
        	  });
        	  $('#datalist').append(tr);
          });
          $.each(gu_list, function(i, info){
        	  $('#gu').append(`<option value=${info}>${info}</option>`);
          })
        }
        $('#gu').click(function(){ // option select 선택시 발생 이벤트
        	var input_dong = $('#gu option:selected').val();
        	$('#dong').empty();
        	$('#dong').append(`<option>법정동</option>`)
        	dong_list.map(item => {
        		var address = item.split(", ");
        		if(address[0] == input_dong){ // 선택된 옵션에 따라서 동적으로 동 정보를 출력
        			$('#dong').append(`<option value=${address[1]}>${address[1]}</option>`)
        		}
        	})
        })
        
        $('#dong').click(function(){ // 동 클릭시 지도 대신에 매칭되는 데이터 테이블로 출력
        	var input_dong = $('#dong option:selected').val();
        	if(input_dong != '법정동'){
        		$('#select_data').empty();
        		var temp = input_data;
        		var first_line = temp[0].split(',');
        		$.each(first_line, function(index, item){
        			$('#select_data').append(`<th>${item}</th>`);
        		})
        		$.each(temp, function(index, item){
        			var data = item.split(',');
        			var tr=$('<tr>');
        			var flag = false;
        			$.each(data, function(i, info){
        				var temp = info;
        				if(index > 0 && i == 0){
        					var address = info.split(' ')
        					if(address[2] == input_dong) {
        						$('#select_data').append(tr);
        						flag = true;
        					}
        				}
        				if(flag == true){
        					$(`<td>${temp}</td>`).appendTo(tr);
        				}
        			});
        			
        		})
        	}
        })
        
        $('.searchBtn').click(function(){ // 검색 버튼 클릭시 페이지 이동
        	var input_dong = $('#dong').val();
        	var input_gu = $('#gu').val();
        	location.href=`./search.html?${input_gu}&${input_dong}`; // url 파라미터에 검색 데이터를 담아서 전달
        })
        
        var url_data = decodeURI(location.search).substr(1).split('&');
        if(url_data){ // 검색버튼 클릭시 url이동 후 로직
        	
        	$('#search_data').append(`<h2>${url_data[0]} ${url_data[1]} 거래정보</h2>`);
        	setTimeout(() => {
        		var temp = input_data;
        		$.each(temp, function(index, item){
                	  var data = item.split(',');
                	  var tr=$('<tr>');
                	  var flag = false;
                	  $.each(data, function(i, info){
                		  var temp = info;
                		  if(index > 0 && i == 0){
                			  var address = info.split(' ')
                			  if(address[1] == url_data[0] && address[2] == url_data[1]) {
                				  flag = true;
                			  }
                		  }
                		  if(flag == true)$(`<td>${temp}</td>`).appendTo(tr);
                	  });
                	  $('#search_data').append(tr);
                	})
        		}, 10);
        	
        }
      });