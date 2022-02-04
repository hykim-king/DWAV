<%--
/**
  file name: illegalArgumentException.jsp
  description: IllegalArgumentException 처리
  user: HKEDU
  create date: 2022-01-20
  version: 0.5
  Copyright (c) by PCWK All right reserved.
  Modification Information
   수정일   수정자    수정내용
 -----------------------------------------------------
  2022-01-20 최초생성
 -----------------------------------------------------
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="CP"        value="${pageContext.request.contextPath}"/>
<c:set var="resource"  value="/resources"/>  
<c:set var="CP_RES"    value="${CP }/resources" />   
<!DOCTYPE html>
<html>    
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    
    <title>제목</title>
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
    	
    });
    </script>
</head>
<body>
     <!-- 반응형 고정폭 콘테이너 : container-->
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h2>illegalArgumentException</h2>
                    <div class="error-details">
                      <h2>요청 처리 과정에 에러가 발생 했습니다.</h2>
                     <p>request_uri : <c:out value="${requestScope['javax.servlet.error.request_uri']}"/></p> 
                     <p>status_code : <c:out value="${requestScope['javax.servlet.error.status_code']}"/></p> 
                     <p>servlet_name : <c:out value="${requestScope['javax.servlet.error.servlet_name']}"/></p> 
                     <p>exception : <c:out value="${requestScope['javax.servlet.error.exception']}"/></p> 
                     <p>servlet_name : <c:out value="${requestScope['javax.servlet.error.servlet_name']}"/></p> 
                     <p>message : <c:out value="${requestScope['javax.servlet.error.message']}"/></p>                                                  
                    </div>
                </div>
            </div>
        </div>
    </div>  
     <!--// 반응형 고정폭 콘테이너 ------------------------------------------------------------->
</body>
</html>