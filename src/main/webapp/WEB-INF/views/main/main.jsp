<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
    String login_id = (String)session.getAttribute("login_id");
%>
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
         var checkShow = false;
         $("#searchSubmitBtn").click(function(){
            //alert($("#city").val() + " , " + $("#datepicker1").val() + " ~ " + $("#datepicker2").val() +" , "+$("#personnel option:selected").val());
            if($("#city").val() == "모든 위치" || $("#city").val() == ""){
               alert("위치를 입력해 주세요.");
            }else if($("#datepicker1").val() == "체크인 날짜" || $("#datepicker1").val() == ""){
               alert("출발 날짜를 입력해 주세요.");
            }else if($("#datepicker2").val() == "체크아웃 날짜" || $("#datepicker2").val() == ""){
               alert("도착 날짜를 입력해 주세요.");
            }else{
               location.href="searchInListFromMainGet.do?city="+$("#city").val()+"&startDate="+$("#datepicker1").val()+"&endDate="+$("#datepicker2").val()+"&person="+$("#personnel").val();
            }
         });
             $("#datepicker1").datepicker({
             dateFormat: 'yy-mm-dd'
         });      
         $("#datepicker2").datepicker({
             dateFormat: 'yy-mm-dd'
         });
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
            window.location="index.jsp";
         });
//          var session = 0;
//          if(session == null){
//             $("#noMemberStatus").show();
//             $("#memberStatus").hide();
//          }else{
//             $("#noMemberStatus").hide();
//             $("#memberStatus").show();
//          }
         $("#body").css('height', 700); 
//          $("#personnel").change(function(){
//             //alert($("#personnel option:selected").val());
//          });
//          $("#roomsListLink").click(function(){
//             location.href = "???.do?accom_id="+realAccom_id;
//          });
      });
      
   </script>
   <%
      String id = (String) session.getAttribute("userid");
   %>
</head>
<body class="body">
   <div id="top">
      <img src="/src/main/resources/img/logo.png" id="logo">
      <div id="memberStatus">
         <c:choose>
         <c:when test="${msg =='failure'}">
         <div id="nomemberStatusWrapper">
            <div id="noMemberStatus">
               <a class="indexFont" href="join.jsp">회원가입</a>
               &nbsp;&nbsp;&nbsp;&nbsp;
               <a class="indexFont" href="login.jsp">로그인</a>
            </div>
         </div>   
         </c:when> 
         <c:when test="${msg == null}"> <!-- 로그인X -->
         
         <% 
            if(login_id == null){
         %>
         
         <div id="nomemberStatusWrapper">
            <div id="noMemberStatus">
               <a class="indexFont" href="host.jsp">호스트</a>
               <a class="indexFont" href="../user/user_reg.do">회원가입</a>
               <a class="indexFont" href="../user/login_view.do">로그인</a>
            </div>
         </div>   
         <%
            }else{
         %>
         <div id="memberStatusWrapper">
            <div id="memberStatus">
               <p id="memberStatusFont"><%=login_id %>님 반갑습니다!</p>
            </div>   
            <div id="tempImg">
               <h2 style="color:#fff;">&nbsp;&nbsp;메뉴</h2>
               <div id="rollDown">
                  <div class="list-group">
                    <a href="mypage.jsp" class="list-group-item list-group-item-action">마이 페이지</a>
                    <a href="gethomeList.do?userId=<%=id %>" class="list-group-item list-group-item-action">예약 리스트</a>
                    <a href="roomsList.jsp" class="list-group-item list-group-item-action">숙박지 리스트</a>
                    <a href="../user/logout.do" class="list-group-item list-group-item-action">로그아웃</a>
                  </div>
               </div>
            </div>   
         </div>
         <%} %>
         </c:when> 
         <c:otherwise>
         <div id="memberStatusWrapper">
            <div id="memberStatus">
               <p id="memberStatusFont"><%=login_id %>님 반갑습니다!</p>
            </div>   
            <div id="tempImg">
               <h2 style="color:#fff;">&nbsp;&nbsp;메뉴</h2>
               <div id="rollDown">
                  <div class="list-group">
                    <a href="mypage.jsp" class="list-group-item list-group-item-action">마이 페이지</a>
                    <a href="gethomeList.do?userId=<%=id %>" class="list-group-item list-group-item-action">예약 리스트</a>
                    <a href="roomsList.jsp" class="list-group-item list-group-item-action">숙박지 리스트</a>
                    <a href="logout.do" class="list-group-item list-group-item-action">로그아웃</a>
                  </div>
               </div>
            </div>   
         </div>
         </c:otherwise>
         </c:choose>
      </div>
   </div>
   <div id="body" style="background-image: URL(img/background2.jpg); background-repeat: no-repeat; width: 100%;">
      <div id="searchBar">
         <form id="seatrchForm">
            <div id="search" class="radius">
            <p id="indexH1">DWAV 숙소 찾기</p>
            <p id="indexH4">혼자 하는 여행에 적합한 개인실부터 여럿이 함께하는 여행에 좋은<br> 집 전체 숙소까지, DWAV 다 있습니다.</p>
               <div id="cityDiv">
                  <p class="searchFont">위치</p>
                  <input type="text" id="city" name="city" value="모든 위치">
               </div>
               <div id="datepickerDiv">
                  <p class="searchFont">날짜</p>
                  <input type="text" id="datepicker1" name="startDate" value="체크인 날짜">
                  &nbsp;&nbsp;~&nbsp;&nbsp;
                  <input type="text" id="datepicker2" name="endDate" value="체크아웃 날짜">
               </div>
               <div id="personnelDiv">
               <p class="searchFont">인원</p>
                  <select id="personnel" name="person">
                     <option value=1>인원 1명</option>
                     <option value=2>인원 2명</option>
                     <option value=3>인원 3명</option>
                     <option value=4>인원 4명</option>
                     <option value=5>인원 5명</option>
                     <option value=6>인원 5명+</option>
                  </select>
               </div>
               <input type="button" id="searchSubmitBtn" value="검색" style="cursor:pointer;">
            </div>
         </form>
      </div>
   </div>
   <div id="footer">
      <div id="footerContentsWrapepr">
         <div id="footerContents1">
            <img id="footerLogo" src="/main/resources/img/logo.png"/>
            <p id="footerP1">공지사항</p><p id="footerP1Right">2조 화이팅!! 모두들 수고많았습니다!! 6달 동안 정말 즐거웠고 남은 기간도 잘 보내요!!</p>
         </div>
         <div id="footerContents2">
            <p id="footerP2">회사소개 · 광고안내 · 검색등록 · 제휴문의 · 인재채용 · 서비스약관 · 청소년보호정책 · 개인정보처리방침 · 웹접근성안내 · 고객센터<br>
            Copyright © DWAV Corp. All rights reserved.      
            </p>
         </div>
      </div>
   </div>
</body>
</html>