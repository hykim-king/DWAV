<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="CP"        value="${pageContext.request.contextPath}"/>
<c:set var="resource"  value="/resources"/>  
<c:set var="CP_RES"    value="${CP }${resource}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
   
   
    <title>숙소, 트립, 장소를 모두 한 곳에서 - DWAV </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script type="text/javascript" src="${CP_RES}/js/jquery-3.6.0.min.js"></script>
    <!-- ajax 통신 -->
    <script type="text/javascript" src="${CP_RES}/js/eclass.js"></script>
    <script type="text/javascript" src="${CP_RES}/js/eUtil.js"></script>
       
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES}/js/bootstrap.min.js"></script>
    <script src="${CP_RES}/js/jquery.bootpag.js"></script>
    <script type="text/javascript">
    <%String id = (String) session.getAttribute("userid");%>
    $(document).ready(function(){
       var bodyHeight = $("#body").height() + 20;
       var accommodation_id;
       $("#body").css('height', bodyHeight);          
       $("#topSearchSubmitBtn").click(function(){
          alert($("#topCity").val() + " , " + $("#topDatepicker1").val() + " ~ " + $("#topDatepicker2").val() +" , "+$("#topPersonnel option:selected").val());
       });
       var checkShow = false;
       $("#rollDown").hide();
       $("#tempImg").click(function(){
          if(checkShow == false){
             $("#rollDown").show();
             checkShow = true;
          }else{
             $("#rollDown").hide();
             checkShow = false;
          }
       });
       
       $("#logo").click(function(){
          window.location="main.jsp";
       });
       $("#minusMaxSleepRoomsBtn").click(function(){
          var maxSleepRoomsCnt = parseFloat($("#maxSleepRoomsCnt").text());
           if(maxSleepRoomsCnt <= 1){
              alert("1 이하는 설정할 수 없습니다.");
           }else{
             $("#maxSleepRoomsCnt").text(maxSleepRoomsCnt-1);
           }
       });
       $("#plusMaxSleepRoomsBtn").click(function(){
          var maxSleepRoomsCnt = parseFloat($("#maxSleepRoomsCnt").text());
          $("#maxSleepRoomsCnt").text(maxSleepRoomsCnt+1);
       });
       $("#minusSleepBedBtn").click(function(){
          var maxSleepBedCnt = parseFloat($("#maxSleepBedCnt").text());
           if(maxSleepBedCnt <= 0){
              alert("0 이하는 설정할 수 없습니다.");
           }else{
             $("#maxSleepBedCnt").text(maxSleepBedCnt-1);
           }
       });
       $("#plusSleepBedBtn").click(function(){
          var maxSleepBedCnt = parseFloat($("#maxSleepBedCnt").text());
          $("#maxSleepBedCnt").text(maxSleepBedCnt+1);
       });
       $("#minusMaxBathBtn").click(function(){
           var maxBathCnt = parseFloat($("#maxBathCnt").text());
           if(maxBathCnt <= 0){
              alert("0 이하는 설정할 수 없습니다.");
           }else{
             $("#maxBathCnt").text(maxBathCnt-1);
           }
       });
       $("#plusMaxBathBtn").click(function(){
           var maxBathCnt = parseFloat($("#maxBathCnt").text());
          $("#maxBathCnt").text(maxBathCnt+1);
       });
       $("input[type=text]").click(function(){
          $(this).val("");
       });
       $("#roomsDetailInfoDescript").text("");
       
    // 업로드 버튼 숨김
		document.getElementById('submitBtn').style.visibility='hidden';
		$('#submitBtn').click(function() {
	           var data = new FormData();
	           $.each($('#img')[0].files, function(i, file) {
	               data.append('file-' + i, file);	                
	           });
	           data.append('accom_id', accommodation_id);
	           
	           //alert(accommodation_id);
	            
	           $.ajax({
	               url: 'upload.do',
	               type: "post",
	               dataType: "text",
	               data: data,
	               // cache: false,
	               processData: false,
	               contentType: false,
	               success: function(data, textStatus, jqXHR) {
	            	   console.log(data);
	               }, error: function(jqXHR, textStatus, errorThrown) {}
	           });
	           
	        	// 업로드 실행
				$('#submitBtn').trigger('click');	
	       });
       
       $("#addRoomsBtn").click(function(){
          if($('select[id="roomsBuildType"]').val() == "default"){
             alert("숙소의 건물 유형을 선택해주세요.");
          }else if($("#setName").val() == "숙소 제목" || $("#setName").val() == ""){
             alert("숙소의 이름을 지정해주세요.");
          }else if($("#payment").val() == "" || $("#payment").val() == "1박 가격"){
             alert("가격을 지정해주세요.");
          }else{
             
             var data = {}
             
             data["accom_id"] = $("#accom_id").val();
             data["room_type"] = $("select[name=room_type]").val();
             data["accomodates"] = $("select[name=accomodates]").val();  
             data["property_type"] = $("select[name=property_type]").val();
             data["building_type"] = $("select[name=building_type]").val();
             data["bedrooms"] = $("select[name=bedrooms]").val();
             data["beds"] = $("font[name=beds]").text();
             data["bathrooms"] = $("font[name=bathrooms]").text();
             data["national_name"] = $("select[name=national_name]").val();

             data["location"] = $("input[name=address1]").val()+" "+ $("[name=address2]").val() +" "+ $("[name=address3]").val() +" "+ $("[name=address4]").val() +" "+ $("[name=address5]").val(); //address1+" "+address2+" "+address3+" "+address4+" "+address5";

             data["amenity_essential"] = (String)($('input[name=amenity_essential]').is(":checked"));
             data["amenity_wifi"] = (String)($("input[name=amenity_wifi]").is(":checked"));
             data["amenity_shampoo"] = (String)($("input[name=amenity_shampoo]").is(":checked"));
             data["amenity_closet"] = (String)($("input[name=amenity_closet]").is(":checked"));
             data["amenity_tv"] = (String)($("input[name=amenity_tv]").is(":checked"));
             data["amenity_heating"] = (String)($("input[name=amenity_heating]").is(":checked"));
             data["amenity_airconditioner"] = (String)($("input[name=amenity_airconditioner]").is(":checked"));
             data["amenity_breakfast"] = (String)($("input[name=amenity_breakfast]").is(":checked"));

             data["securityFacility_smoke"] = (String)($("input[name=securityFacility_smoke]").is(":checked"));
             data["securityFacility_cm"] = (String)($("input[name=securityFacility_cm]").is(":checked"));
             data["securityFacility_firstaidkit"] = (String)($("input[name=securityFacility_firstaidkit]").is(":checked"));
             data["securityFacility_fire"] = (String)($("input[name=securityFacility_fire]").is(":checked"));
             data["securityFacility_locker"] = (String)($("input[name=securityFacility_locker]").is(":checked"));

             data["usableFacility_pridatavatelivingroom"] = (String)($("input[name=usableFacility_privatelivingroom]").is(":checked"));
             data["usableFacility_pool"] = (String)($("input[name=usableFacility_pool]").is(":checked"));
             data["usableFacility_kitchen"] = (String)($("input[name=usableFacility_kitchen]").is(":checked"));
             data["usableFacility_washer"] = (String)($("input[name=usableFacility_washer]").is(":checked"));
             data["usableFacility_dryer"] = (String)($("input[name=usableFacility_dryer]").is(":checked"));
             data["usableFacility_park"] = (String)($("input[name=usableFacility_park]").is(":checked"));
             data["udatasableFacility_ele"] = (String)($("input[name=usableFacility_ele]").is(":checked"));
             data["usableFacility_tub"] = (String)($("input[name=usableFacility_tub]").is(":checked"));
             data["usableFacility_gym"] = (String)($("input[name=usableFacility_gym]").is(":checked"));

             data["img"] = $("input[name=img]").val();
             data["description"] = $("textarea[name=description]").val();

             data["goodThing_family"] = (String)($("input[name=goodThing_family]").is(":checked"));
             data["goodThing_group"] = (String)($("input[name=goodThing_group]").is(":checked"));
             data["goodThing_withpet"] = (String)($("input[name=goodThing_withpet]").is(":checked"));
                            
             data["name"] = $("input[name=name]").val();   //숙소 이름
             data["price"] = $("input[name=price]").val();   
             data["cdataurrency_unit"] = $("select[name=currency_unit]").val();

             data["host_id"] = $("input[name=host_id]").val();   //session값
             data["avg_point"] = $("input[name=avg_point]").val();
             
             accommodation_id = $("#accom_id").val();
          	// 업로드 실행
				$('#submitBtn').trigger('click');	
             
             $.ajax({
                contentType:'application/json',
                dataType:'json',
                data : JSON.stringify(data),
                url : "InsertHome.do?id=<%=id%>",
                type : "GET",                  
                success : function(data){
                   console.log(data);
                   alert("등록되었습니다.");
                }   
             });
             window.location="main.jsp";
          }
       });
    });
 </script>
</head>
<body class="body">
	<div id="top">
		<img src="img/logo.png" id="logo">
		<div id="memberStatus">
			<%
				if (id == null) {
			%>

			<div id="nomemberStatusWrapper">
				<div id="noMemberStatus">
					<a class="indexFont" href="join.jsp">회원가입</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a class="indexFont" href="login.jsp">로그인</a>
				</div>
			</div>
			<%
				} else {
			%>
			<div id="memberStatusWrapper">
				<div id="memberStatus">
					<p id="memberStatusFont"><%=id%>님 반갑습니다!
					</p>
				</div>
				<div id="tempImg">
					<h2 style="color: #fff;">&nbsp;&nbsp;메뉴</h2>
					<div id="rollDown">
						<div class="list-group">
							<a href="mypage.jsp" class="list-group-item list-group-item-action">마이 페이지</a> 
							<a href="getReservList.do?userId=<%=id%>" class="list-group-item list-group-item-action">예약 리스트</a> 
							<a href="roomsList.jsp" class="list-group-item list-group-item-action">숙박지 리스트</a> 
							<a href="logout.do" class="list-group-item list-group-item-action">로그아웃</a>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div id="body">
		<div id="contentsWrapper">
			<!--<form id="addRoomsForm" method="post" action="addAccommodation.do"> -->
			<hr style="border: solid 2px #FF5A5F; width: 98%;">
			<h2>회원님의 숙소 유형은 무엇인가요?</h2>
			<div id="roomsType">
				<input type="hidden" id="accom_id" name="accom_id" value=0>
				<select id="roomsTypeList" name="room_type">
					<option value="개인실">개인실</option>
					<option value="집 전체">집 전체</option>
					<option value="다인실">다인실</option>
				</select> 
				<select id="roomsTypeNum" name="accomodates">
					<option value=1>최대 1명 숙박 가능</option>
					<option value=2>최대 2명 숙박 가능</option>
					<option value=3>최대 3명 숙박 가능</option>
					<option value=4>최대 4명 숙박 가능</option>
					<option value=5>최대 5명 숙박 가능</option>
					<option value=6>최대 6명 숙박 가능</option>
					<option value=7>최대 7명 숙박 가능</option>
					<option value=8>최대 8명 숙박 가능</option>
					<option value=8>최대 9명 이상 가능</option>
				</select>
			</div>
			<h2>숙소 유형을 집, 호텔, 기타 중에서 골라주세요.</h2>
			<select id="roomsTypeSelect" name="property_type">
				<option value="집">집</option>
				<option value="호텔">호텔</option>
				<option value="펜션">펜션</option>
				<option value="리조트">리조트</option>
				<option value="호스텔">호스텔</option>
				<option value="콘도">콘도</option>
				<option value="게스트하우스">게스트하우스</option>
				<option value="여관">여관</option>
				<option value="민박">민박</option>
				<option value="기타">기타</option>
			</select>
			<h2>숙소의 건물 유형을 알려주세요.</h2>
			<select id="roomsBuildType" name="building_type">
				<option value="default">하나를 선택해주세요.</option>
				<option value="아파트">아파트</option>
				<option value="게스트하우스">게스트하우스</option>
				<option value="단독주택">단독주택</option>
				<option value="별채">별채</option>
				<option value="휴가용 별장">휴가용 별장</option>
			</select> <br>
			<br>
			<h2>게스트가 사용할 수 있는 침실은 몇 개인가요?</h2>
			<select id="roomsSleepCnt" name="bedrooms">
				<option value=0>침실 0개</option>
				<option value=1>침실 1개</option>
				<option value=2>침실 2개</option>
				<option value=3>침실 3개</option>
				<option value=4>침실 4개</option>
				<option value=5>침실 5개</option>
				<option value=6>침실 6개</option>
			</select>
			<h2>게스트가 사용할 수 있는 침실은 몇 개인가요?</h2>
			<font>침대</font> 
			<input type="button" id="minusSleepBedBtn" value="-"></input>
			&nbsp;<font id="maxSleepBedCnt" name="beds">1</font>&nbsp; 
			
			<input type="button" id="plusSleepBedBtn" value="+"></input>
			&nbsp;&nbsp;&nbsp;&nbsp; 
			<font>욕실</font> 
			<input type="button" id="minusMaxBathBtn" value="-"></input> &nbsp;
			<font id="maxBathCnt" name="bathrooms">1</font>&nbsp; 
			<input type="button" id="plusMaxBathBtn" value="+"></input>
			<hr style="border: solid 2px #FF5A5F; width: 98%;">
			
			<h2>숙소의 위치를 알려주세요.</h2>
			<br> <font size="4px"><b>시/도
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 시군</b></font><br>
			<input type="text" id="address1" name="address1" value="서울특별시" /> 
			<input type="text" id="address2" name="address2" value="예) 강남구" />
			<h3>도로명 / 건물번호 / 아파트 이름 / 건물 이름</h3>
			<input type="text" id="address3" name="address3" value="예) 언주로 406">
			<h3>아파트 / 건물명 및 동 / 호수 (선택사항)</h3>
			<input type="text" id="address4" name="address4" value="예) ??동  ??호">
			<h3>도로명 / 건물번호 / 아파트 이름 / 건물 이름</h3>
			<input type="text" id="address5" name="address5" value="예) 135-919">

			<input type="hidden" value="" name="location">
			<!-- location에 address합쳐서 보내는 form -->
			<hr style="border: solid 2px #FF5A5F; width: 98%;">
			
			
			<h2>어떤 편의시설을 제공하시나요?</h2>
			<input type="checkbox" name="amenity_essential" />필수 품목(수건, 침대시트, 비누,화장지)<br> 
			<input type="checkbox" name="amenity_wifi" />무선인터넷<br>
			<input type="checkbox" name="amenity_shampoo" />샴푸<br> 
			<input type="checkbox" name="amenity_closet" />옷장/서랍장<br> 
			<input type="checkbox" name="amenity_tv" />TV<br> 
			<input type="checkbox" name="amenity_heating" />난방<br> 
			<input type="checkbox" name="amenity_airconditioner" />에어컨<br> 
			<input type="checkbox" name="amenity_breakfast" />조식, 커피, 차<br>

			<h2>안전시설</h2>
			<input type="checkbox" name="securityFacility_smoke" />연기 감지기<br>
			<input type="checkbox" name="securityFacility_cm" />일산화탄소 감지기<br>
			<input type="checkbox" name="securityFacility_firstaidkit" />구급상자<br>
			<input type="checkbox" name="securityFacility_fire" />소화기<br> 
			<input type="checkbox" name="securityFacility_locker" />침실문 잠금장치<br>

			<h2>게스트가 어떤 공간을 사용할 수 있나요?</h2>
			<input type="checkbox" name="usableFacility_privatelivingroom" />개인거실<br> 
			<input type="checkbox" name="usableFacility_pool" />수영장<br>
			<input type="checkbox" name="usableFacility_kitchen" />부엌<br> 
			<input type="checkbox" name="usableFacility_washer" />빨래 - 세탁기<br> 
			<input type="checkbox" name="usableFacility_dryer" />빨래 - 건조기<br> 
			<input type="checkbox" name="usableFacility_park" />주차<br> 
			<input type="checkbox" name="usableFacility_ele" />엘리베이터<br> 
			<input type="checkbox" name="usableFacility_tub" />자쿠지 욕조<br> 
			<input type="checkbox" name="usableFacility_gym" />헬스장<br>
			<hr style="border: solid 2px #FF5A5F; width: 98%;">
			
			
			<h2>숙소의 모습을 보여 주세요.</h2>
			<form id="frm" name="frm" enctype="multipart/form-data">
				<input type="file" id="img" name="img">
				<button type="button" id="submitBtn">upload</button>
			</form>
			<h2>숙소 설명</h2>
			<h3>요약</h3>
			<textarea rows="10" cols="60" id="roomsDetailInfoDescript"
				name="description"> 
				</textarea>
			<h2>숙소의 좋은 점</h2>
			<input type="checkbox" name="goodThing_family" />(아이 동반)가족<br> 
			<input type="checkbox" name="goodThing_group" />단체<br> 
			<input type="checkbox" name="goodThing_withpet" />반려동물 동반<br>

			<h2>이름 지정</h2>
			<input type="text" id="setName" name="name" value="숙소 제목" />
			<h2>기본 요금</h2>
			<input type="text" id="payment" name="price" value="1박 가격" />
			<h2>통화 단위</h2>
			<select id="currencyUnit" name="currency_unit">
				<option value="krw">원</option>
			</select> <br>
			
			<br> 
			<input type="hidden" id="host_id" name="host_id" value="<%=id%>"> 
			<input type="hidden" id="avg_point" name="avg_point" value=0> 
			<input type="submit" id="addRoomsBtn" value="숙소 등록">
			<hr style="border: solid 2px #FF5A5F; width: 98%;">
			<!-- </form> -->
		</div>
	</div>
	<div id="footer">
		<div id="footerContentsWrapepr">
			<div id="footerContents1">
				<img id="footerLogo" src="img/logo.png" />
				<p id="footerP1">공지사항</p>
				<p id="footerP1Right">2조 화이팅!! 모두들 수고많았습니다!! 2달 동안 정말 즐거웠고 남은
					기간도 잘 보내요!!</p>
			</div>
			<div id="footerContents2">
				<p id="footerP2">
					회사소개 · 광고안내 · 검색등록 · 제휴문의 · 인재채용 · 서비스약관 · 청소년보호정책 · 개인정보처리방침 ·
					웹접근성안내 · 고객센터<br> Copyright © DWAV Corp. All rights
					reserved.
				</p>
			</div>
		</div>
	</div>
</body>
</html>