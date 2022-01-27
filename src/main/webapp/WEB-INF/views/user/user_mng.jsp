<%--
/**
  file name: 
  description:
  user: Dosn
  create date: 2022-01-25
  version: 0.5
  Copyright (c) by PCWK All right reserved.
  Modification Information
   수정일   수정자    수정내용
 -----------------------------------------------------
  2022-01-25 최초생성
 -----------------------------------------------------
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>회원관리(관리자용)</title>
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
	$(document).ready(function() {
		
		
		
		  $("#doInsert").on("click",function(e){
			 console.log("doInsert:");
			 window.location.href="${CP}/user/user_reg.do";
		  });

		  /* 유저의 정보 수정 기능은 로그인 이후, 세션 정보를 통해 이루어져야 하므로, 로그인 화면부터 만들자. */
 		  $("#doUpdate").on("click",function(e){
			 console.log("doUpdate:");
             window.location.href ="${CP}/user/user_upd.do";
		  }); 

		
		
		
		
		  //검색 버튼 이벤트 정의
		  $("#doRetrieve").on("click", function(e){
			  console.log("${CP_RES}");
			  console.log("doRetrieve");
			  e.preventDefault();
			  doRetrieve(1); // 뒤에서 function doRetrieve만들기, 첫 페이지 조회
		  });
		  
		  function doRetrieve(page){
              let url = "${CP}/user/doRetrieve.do";
              let parameters = {                    
                      pageSize: $("#pageSize").val(),
                      pageNum: page,
                      searchDiv: $("#searchDiv").val(),
                      searchWord: $("#searchWord").val()};
              let method = "GET";
              let async  = true;
              
              EClass.callAjax(url,parameters,method,async,function(data){
            	  console.log("data.totalCnt:\n"+data.totalCnt);
                  let parsedData = data;
                  //1.기존 데이터 삭제
                  $("#user_table>tbody").empty();
                  //2.신규 데이터 출력
                  
                  console.log("parsedData.length:"+parsedData.length);
                  
                  let html ="";
                  
                  let totalCount = 0;//총글수
                  let pageTotal  = 1;//페이지수 
                  
                  
                  //데이터 있는 경우
                  if(parsedData.length>0){
                      console.log("parsedData[0].totalCnt:"+parsedData[0].totalCnt);
                      totalCount = parsedData[0].totalCnt;
                      //42/10 -> 5
                      pageTotal = (totalCount/$("#pageSize").val());
                      pageTotal = Math.ceil(pageTotal);
                      
                      
                      
                      $.each(parsedData, function(i, value) {
                          console.log("i:"+value.name);
                          html+=" <tr>                                                ";
                          html+="   <td class='text-center'>"+value.num+        "</td>";
                          html+="   <td class='text-left'>"  +value.user_id+    "</td>";
                          html+="   <td class='text-left'>"  +value.first_name+ "</td>";
                          html+="   <td class='text-center'>"+value.last_name+  "</td>";
                          html+="   <td class='text-left'>"  +value.birth_date+ "</td>";
                          html+="   <td class='text-center'>"+value.email+      "</td>";
                          html+="   <td class='text-center'>"+value.user_ph_num+"</td>";
                          html+="   <td class='text-center'>"+value.join_date+  "</td>";
                          html+=" </tr>                                               ";
                      });
                  //데이터 없는 경우    
                  }else{
                          html+="<tr>                                                 ";
                          html+="     <td colspan='99' class='text-center'>No data found</td>  ";
                          html+="</tr>                                                ";                      
                  }
                  
                  //table 데이터
                  $("#user_table>tbody").append(html);
                  
                  //paging 기존 데이터 삭제
                  $("#page-selection").empty();
                  
                  //paging 처리(renderingPage)
                  renderingPage(pageTotal,page);

              });
              
              
          }//--doRetrieve
          
	         function renderingPage(pageTotal,page){
	               console.log("renderingPage:"+ pageTotal)  ; 
	               
	               pageTotal = parseInt(pageTotal);
	               console.log("pageTotal:"+ pageTotal)  ; 
	               //이전 연결된 EventHandler제거 
	               $('#page-selection').unbind('page');
	           
	               $('#page-selection').bootpag({
	                    total: pageTotal,
	                    page: page,
	                    maxVisible: 10,
	                    leaps: true,
	                    firstLastUse: true,
	                    first: '←',
	                    last: '→',
	                    wrapClass: 'pagination',
	                    activeClass: 'active',
	                    disabledClass: 'disabled',
	                    nextClass: 'next',
	                    prevClass: 'prev',
	                    lastClass: 'last',
	                    firstClass: 'first'
	                }).on("page", function(event, num){
	                    console.log("num:"+num);
	                    doRetrieve(num)
	                });                
	           }
	});
</script>
</head>
<body>
	<!-- 반응형 고정폭 콘테이너 : container-->
	<div class="container">

		<!-- 제목 -->
        <div class="row col-xs-7 col-sm-7 col-md-7 col-lg-7">
			<div class="page-header">
				<h2>회원 관리(관리자용)</h2>
			</div>
		</div>
		<!--// 제목 ------------------------------------------------------------->

		<!-- 검색 display: inline-block;-->
		<div class="row text-right">
           <form action="#" class="form-inline col-xs-14 col-sm-14 col-md-14 col-lg-14">
             <div class="form-group">
                <select class="form-control  input-sm" id="searchDiv" name="searchDiv">
						<!-- 검색 구분자, 10 : user_id, 20 : first_name, 30 : last_name, 
                            40 : birth_date, 50 : email, 60 : user_ph_num, 70 : join_date -->
						<option value="10">아이디</option>
						<option value="20">이름</option>
						<option value="30">성</option>
						<option value="40">생일</option>
						<option value="50">이메일</option>
						<option value="60">전화번호</option>
						<option value="70">가입날짜</option>
					</select>
					<input type="text" class="form-control input-sm" placeholder="검색어" id="searchWord" name="searchWord" />
					<select class="form-control input-sm" id="pageSize" name="pageSize">
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="200">200</option>
					</select>
            <!-- 버튼 ------------------------------------------------------------->
					<input type="button" class = "btn btn-default btn-sm"value = "검색" id="doRetrieve"/>
            <!--// 버튼 ------------------------------------------------------------->

				</div>
			</form>
		</div>
		<!--// 검색 ------------------------------------------------------------->

		<!-- 검색결과 ------------------------------------------------------------->
        <div class = "row">
            <div class="col-xs-14 col-sm-14 col-md-14 col-lg-14">
                <table id = "user_table" class = "table table-bordered table-striped">
                    <thead>
                        <tr class = "bg-primary">
                            <th class ="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">번호</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">아이디</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">이름</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">성</th>
                            <th class ="text-center col-xs-3 col-sm-3 col-md-3 col-lg-1">생일</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">이메일</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">전화번호</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">가입 날짜</th>
                        </tr>
                    </thead>
                    <tbody>
						<c:choose>
							<c:when test="${list.size()>0}">
								<c:forEach var="vo" items="${list }">
									<tr>
										<td class = "text-center">${vo.num}</td>
										<td class = "text-left">${vo.user_id}</td>
										<td class = "text-left">${vo.first_name}</td>
										<td class = "text-left">${vo.last_name}</td>
										<td class = "text-center">${vo.birth_date}</td>
										<td class = "text-left">${vo.email}</td>
										<td class = "text-center">${vo.user_ph_num}</td>
										<td class = "text-center">${vo.join_date}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td>No data found</td>
								</tr>
							</c:otherwise>
						</c:choose>

					</tbody>
                </table>
            </div>            
        </div>
        <!-- //검색결과 ------------------------------------------------------------->
        
		<!-- 페이징 -->
        <div class="text-center col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div id="page-selection" class="text-center page">
        </div>
		<!--// 페이징  ------------------------------------------------------------->


	</div>
	<!--// 반응형 고정폭 콘테이너 : container----------------------------------------->
	
	     <!-- 초기화, 등록, 수정, 삭제 -->
    <!-- 반응형 고정폭 콘테이너 : container-->
     <div class="container">
             
        <!-- 버튼 -->
           <div class="row text-right">
              <input type="button" class="btn btn-default btn-sm" value="초기화" id="initBtn">
              <input type="button" class="btn btn-default btn-sm" value="등록" id="doInsert">
              <input type="button" class="btn btn-default btn-sm" value="수정" id="doUpdate">
              <input type="button" class="btn btn-default btn-sm" value="삭제" id="doDelete">
           </div>
        <!--// 버튼 ------------------------------------------------------------->
  </div>
  </div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>