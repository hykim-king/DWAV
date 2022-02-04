<%--
/**
  file name: 
  description:
  user: Dosn
  create date: 2022-02-03
  version: 0.5
  Copyright (c) by PCWK All right reserved.
  Modification Information
   수정일   수정자    수정내용
 -----------------------------------------------------
  2022-02-03 최초생성
 -----------------------------------------------------
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String login_id         =(String)session.getAttribute("login_id"        );
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

<title>편의시설관리(관리자용)</title>
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
    	
        $("#doInsert").on("click",function(e){
            console.log("doInsert:");
            window.location.href="${CP}/facilities/facil_reg.do";
         });

        
        $("#facil_table>tbody").on("click","tr",function(e){
        	
        	console.log("#facil_table>tbody");
        	let tds = $(this).children();
        	let amen_id = tds.eq(1).text();
        	//console.log("amen_id = "+amen_id);
        	
        	if(confirm("삭제하시겠습니까?")==false)return;
        	window.location.href ="${CP}/facilities/doDeleteAmen.do?amen_id="+amen_id;
        	
        });
    	
    });
    </script>
</head>
<body>
	<!-- 반응형 고정폭 콘테이너 : container-->
    <div class="container">

        <!-- 제목 -->
        <div class="row col-xs-7 col-sm-7 col-md-7 col-lg-7">
            <div class="page-header">
                <h2>편의시설 관리(관리자용)</h2>
            </div>
        </div>
        <!--// 제목 ------------------------------------------------------------->

        <!-- 검색 display: inline-block;-->
        <div class="row text-right">
           <form action="#" class="form-inline col-xs-14 col-sm-14 col-md-14 col-lg-14">
             <div class="form-group">
                <select class="form-control  input-sm" id="searchDiv" name="searchDiv">
                        <!-- 검색 구분자, 10: amen_id, 20 : accom_id 30 : amenity_type 40 : amenity_val -->
                        <option value="10">편의시설id</option>
                        <option value="20">숙소id</option>
                        <option value="30">편의시설 타입</option>
                        <option value="40">편의시설 명</option>
                        <option value="50">등록자</option>
                        
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
                <table id = "facil_table" class = "table table-bordered table-striped">
                    <thead>
                        <tr class = "bg-primary">
                            <th class ="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">번호</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">편의시설 id</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">숙소 id</th>
                            <th class ="text-center col-xs-2 col-sm-2 col-md-2 col-lg-1">편의시설 타입</th>
                            <th class ="text-center col-xs-3 col-sm-3 col-md-3 col-lg-1">편의시설 명</th>
                            <th class ="text-center col-xs-3 col-sm-3 col-md-3 col-lg-1">등록자</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${list.size()>0}">
                                <c:forEach var="vo" items="${list }">
                                    <tr>
                                        <td class = "text-center">${vo.num}</td>
                                        <td class = "text-left">${vo.amen_id}</td>
                                        <td class = "text-left">${vo.accom_id}</td>
                                        <td class = "text-left">${vo.amenity_type}</td>
                                        <td class = "text-center">${vo.amenity_val}</td>
                                        <td class = "text-center">${vo.reg_id}</td>

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
              <!-- <input type="button" class="btn btn-default btn-sm" value="초기화" id="initBtn"> -->
              <input type="button" class="btn btn-default btn-sm" value="등록" id="doInsert">
              <!-- <input type="button" class="btn btn-default btn-sm" value="삭제" id="doDelete"> -->
           </div>
        <!--// 버튼 ------------------------------------------------------------->
        login_id        : <%=login_id        %><br/>  
        </div>
        </div>
</body>
</html>