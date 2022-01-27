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
       $("#topDatepicker1").datepicker({
           dateFormat: 'yy-mm-dd'
       });      
       $("#topDatepicker2").datepicker({
           dateFormat: 'yy-mm-dd'
       });
       $("#logo").click(function(){
          window.location="main.jsp";
       });
       
       
    
    </script>
  
</head>
<body>
<div id="top">
		<img src="img/logo.png" id="logo">
		<div id="memberStatus">
	

			<div id="nomemberStatusWrapper">
				<div id="noMemberStatus">
					<a class="indexFont" href="join.jsp">회원가입</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a class="indexFont" href="login.jsp">로그인</a>
				</div>
			</div>
		
			<div id="memberStatusWrapper">
				<div id="memberStatus">
					<p id="memberStatusFont">
					</p>
				</div>
				<div id="tempImg">
					<h2 style="color: #fff;">&nbsp;&nbsp;메뉴</h2>
					<div id="rollDown">
						<div class="list-group">
							<a href="mypage.jsp" class="list-group-item list-group-item-action">마이 페이지</a> 
							<a href="getReservList.do?userId=" class="list-group-item list-group-item-action">예약 리스트</a> 
							<a href="roomsList.jsp" class="list-group-item list-group-item-action">숙박지 리스트</a>
							<a href="logout.do" class="list-group-item list-group-item-action">로그아웃</a>
						</div>
					</div>
				</div>
			</div>
		
		
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
					<option value=8>최대 9명 이상 숙박 가능</option>
				</select>
			</div>
			
			
			<h2>숙소 유형을 집, 호텔, 기타 중에서 골라주세요.</h2>
			  <select id="roomsTypeSelect" name="property_type">
				<option value="집">집</option>
				<option value="호텔">호텔</option>
				<option value="리조트">리조트</option>
				<option value="콘도">콘도</option>
				<option value="펜션">펜션</option>
				<option value="여관">여관</option>
				<option value="주택">주택</option>
				<option value="주택">호스텔</option>
				<option value="민박">민박</option>
			  </select>
			
			
			<h2>숙소의 건물 유형을 알려주세요.</h2>
			  <select id="roomsBuildType" name="building_type">
				<option value="default">하나를 선택해주세요.</option>
				<option value="아파트">아파트</option>
				<option value="게스트하우스">게스트하우스</option>
				<option value="단독주택">단독주택</option>
				<option value="별채">별채</option>
				<option value="휴가용 별장">휴가용 별장</option>
			  </select> <br> <br>
	
		
			<h2>숙소의 위치를 알려주세요.</h2>
			<br> <br> 
			<font size="4px"><b>시/도
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 시군</b></font><br>
			<input type="text" id="address1" name="address1" value="서울특별시" /> 
			<input type="text" id="address2" name="address2" value="예) 강남구" />
			<h3>도로명 / 건물번호 / 아파트 이름 / 건물 이름</h3>
			<input type="text" id="address3" name="address3" value="예) 언주로 406">
			<h3>아파트 / 건물명 및 동 / 호수 (선택사항)</h3>
			<input type="text" id="address4" name="address4" value="예) 35동 4층 407호">
			<h3>도로명 / 건물번호 / 아파트 이름 / 건물 이름</h3>
			<input type="text" id="address5" name="address5" value="예) 135-919">

			<input type="hidden" value="" name="location">
			<!-- location에 address합쳐서 보내는 form -->
			<hr style="border: solid 2px #FF5A5F; width: 98%;">


			
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
					웹접근성안내 · 고객센터<br> Copyright © DWAV Corp. All rights reserved.
				</p>
			</div>
		</div>
	</div>
</body>
</html>